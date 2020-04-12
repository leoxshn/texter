package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*
import posidon.mangoTK.util.toBool
import posidon.mangoTK.util.toInt

actual class TextView actual constructor(init: TextView.() -> Unit) : View {

    override val gtkWidget = gtk_text_view_new()!!

    actual var text: String
        get() {
            val startIter: CPointer<GtkTextIter> = nativeHeap.alloc<GtkTextIter>().ptr
            val endIter: CPointer<GtkTextIter> = nativeHeap.alloc<GtkTextIter>().ptr
            val buffer = gtk_text_view_get_buffer(gtkWidget.reinterpret())
            gtk_text_buffer_get_start_iter(buffer, startIter)
            gtk_text_buffer_get_end_iter(buffer, endIter)
            val str = gtk_text_buffer_get_text(buffer, startIter, endIter, 0)!!.toKString()
            nativeHeap.free(startIter)
            nativeHeap.free(endIter)
            return str
        }
        set(value) = gtk_text_buffer_set_text(gtk_text_view_get_buffer(gtkWidget.reinterpret()), value, value.length)

    init { init() }

    actual var monospace: Boolean
        get() = gtk_text_view_get_monospace(gtkWidget.reinterpret()).toBool()
        set(value) = gtk_text_view_set_monospace(gtkWidget.reinterpret(), value.toInt())
}