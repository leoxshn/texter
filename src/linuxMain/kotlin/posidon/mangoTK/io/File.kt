package posidon.mangoTK.io

import gtk3.*
import kotlinx.cinterop.*
import platform.posix.NULL

actual inline class File actual constructor(val path: String) {

    actual fun readText(): String {
        val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
        val channel = g_io_channel_new_file(path, "r+", err)

        val strPtr = nativeHeap.alloc<CPointerVar<ByteVarOf<Byte>>>()
        val lenPtr = nativeHeap.alloc<ULongVar>()
        g_io_channel_read_to_end(channel, strPtr.ptr, lenPtr.ptr, err)
        val text = strPtr.value!!.toKString()
        nativeHeap.free(lenPtr)
        nativeHeap.free(strPtr)
        val error = err.pointed.value?.pointed
        if (error != null) throw Error(error.message!!.toKString())
        return text
    }

    actual fun readBytes(): ByteArray {
        return readText().encodeToByteArray()
    }

    actual fun forEachLine(block: (line: String) -> Unit) {
        val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
        val channel = g_io_channel_new_file(path, "r+", err)
        val strPtr = nativeHeap.alloc<CPointerVar<ByteVarOf<Byte>>>()
        val lenPtr = nativeHeap.alloc<ULongVar>()
        val termPtr = nativeHeap.alloc<ULongVar>()
        while (true) {
            g_io_channel_read_line(channel, strPtr.ptr, lenPtr.ptr, null, err)
            val line = strPtr.value
            val char = line?.get(0)?.toChar()
            if (char != '\n' && char != null) {
                val l = line.toKString()
                block(l.removeRange(l.lastIndex, l.length))
            } else break
        }
        nativeHeap.free(termPtr)
        nativeHeap.free(lenPtr)
        nativeHeap.free(strPtr)
        val error = err.pointed.value?.pointed
        if (error != null) throw Error(error.message!!.toKString())
    }
}