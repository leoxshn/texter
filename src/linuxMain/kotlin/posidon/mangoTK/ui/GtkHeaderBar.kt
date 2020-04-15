package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.nativeNullPtr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import posidon.mangoTK.util.toBool
import posidon.mangoTK.util.toInt

actual class GtkHeaderBar actual constructor(init: GtkHeaderBar.() -> Unit) {

    val actualHeaderBar = gtk_header_bar_new()!!

    actual var title: String
        get() = gtk_header_bar_get_title(actualHeaderBar.reinterpret())!!.toKString()
        set(value) = gtk_header_bar_set_title(actualHeaderBar.reinterpret(), value)

    actual var subtitle: String
        get() = gtk_header_bar_get_subtitle(actualHeaderBar.reinterpret())!!.toKString()
        set(value) = gtk_header_bar_set_subtitle(actualHeaderBar.reinterpret(), value)

    actual var hasSubtitle: Boolean
        get() = gtk_header_bar_get_has_subtitle(actualHeaderBar.reinterpret()).toBool()
        set(value) = gtk_header_bar_set_has_subtitle(actualHeaderBar.reinterpret(), value.toInt())

    actual var showCloseBtn: Boolean
        get() = gtk_header_bar_get_show_close_button(actualHeaderBar.reinterpret()).toBool()
        set(value) = gtk_header_bar_set_show_close_button(actualHeaderBar.reinterpret(), value.toInt())

    init { init() }

    actual abstract class Side actual constructor(val headerBar: GtkHeaderBar, init: Side.() -> Unit): Container() {
        override val container: CPointer<GtkContainer> = headerBar.actualHeaderBar.reinterpret()
        init { init() }
    }

    actual class StartSide actual constructor(headerBar: GtkHeaderBar, init: Side.() -> Unit): Side(headerBar, init) {
        override fun add(view: View) {
            gtk_header_bar_pack_start(headerBar.actualHeaderBar.reinterpret(), view.gtkWidget)
            gtk_widget_show_all(headerBar.actualHeaderBar)
        }
    }

    actual class EndSide actual constructor(headerBar: GtkHeaderBar, init: Side.() -> Unit): Side(headerBar, init) {
        override fun add(view: View) {
            gtk_header_bar_pack_end(headerBar.actualHeaderBar.reinterpret(), view.gtkWidget)
            gtk_widget_show_all(headerBar.actualHeaderBar)
        }
    }
}