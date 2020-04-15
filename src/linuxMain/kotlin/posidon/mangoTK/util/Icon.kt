package posidon.mangoTK.util

import gtk3.*
import kotlinx.cinterop.*

actual enum class Icon(val iconName: String) {
    inline FILE("text-x-generic"),
    inline FOLDER("folder");

    actual fun get(size: IconSize): Bitmap {
        val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
        val strPointer = nativeHeap.allocArrayOf(iconName.cstr.getPointer(object : AutofreeScope() {
            override fun alloc(size: Long, align: Int) = nativeHeap.alloc(size, align)
        }))
        val icon = gtk_icon_theme_choose_icon(gtk_icon_theme_get_default(), strPointer, size.resolution, 0u)
        val pixbuf = gtk_icon_info_load_icon(icon, err)
        nativeHeap.free(strPointer.rawValue)
        val error = err.pointed.value?.pointed
        if (error != null) throw Exception(error.message?.toKString())
        return Bitmap(pixbuf)
    }
}