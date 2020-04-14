package posidon.mangoTK.util

import gtk3.*
import kotlinx.cinterop.*

actual enum class Icon(val iconName: String) {
    FILE("text-x-generic"),
    FOLDER("folder");

    actual fun get(): Bitmap {
        println("1111")
        val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
        val blabla = nativeHeap.allocArrayOf(iconName.cstr.getPointer(object : AutofreeScope() {
            override fun alloc(size: Long, align: Int) = nativeHeap.alloc(size, align)
        }))
        val d = gtk_icon_theme_choose_icon(gtk_icon_theme_get_default(), blabla, 64, 0u)
        val a = gtk_icon_info_load_icon(d, err)
        nativeHeap.free(blabla.rawValue)
        val error = err.pointed.value?.pointed
        if (error != null) throw Exception(error.message?.toKString())
        println("4444")
        return Bitmap(a)
    }
}