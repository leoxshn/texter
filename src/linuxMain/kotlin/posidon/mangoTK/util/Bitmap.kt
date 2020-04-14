package posidon.mangoTK.util

import gtk3.*
import kotlinx.cinterop.*

actual class Bitmap(val pixbuf: CPointer<GdkPixbuf>?) {

    actual companion object {
        actual fun fromFile(path: String): Bitmap? {
            val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
            val a = gdk_pixbuf_new_from_file(path, err)
            val error = err.pointed.value?.pointed
            return if (error == null) Bitmap(a) else null
        }
    }
}