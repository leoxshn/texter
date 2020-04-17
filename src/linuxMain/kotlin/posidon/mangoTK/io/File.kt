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

    actual fun readBytes() = readText().encodeToByteArray()

    actual fun forEachLine(block: (line: String) -> Unit) {
        val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
        val channel = g_io_channel_new_file(path, "r+", err)
        val charPtr = nativeHeap.alloc<UIntVar>()
        val line = StringBuilder()
        loop@ while (true) {
            val status = g_io_channel_read_unichar(channel, charPtr.ptr, err)
            when (val char = charPtr.value.toInt().toChar()) {
                '\n' -> {
                    block(line.toString())
                    line.clear()
                }
                '\uffff' -> {
                    if (status == GIOStatus.G_IO_STATUS_EOF) {
                        block(line.toString())
                        line.clear()
                        break@loop
                    } else line.append(char)
                }
                else -> line.append(char)
            }
        }
        nativeHeap.free(charPtr)
    }
}