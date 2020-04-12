package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString

actual class Tabs actual constructor(init: Tabs.() -> Unit) : View {

    override val gtkWidget: CPointer<GtkWidget> = gtk_notebook_new()!!

    init { init() }

    //val pages = ArrayList<Page>()


    actual class Page actual constructor(val tabs: Tabs, name: String): Container() {

        override var container: CPointer<GtkContainer> = tabs.gtkWidget.reinterpret()

        actual var name: String = "helou"
            //get() = gtk_notebook_get_tab_label_text(tabs.gtkWidget.reinterpret(), container.reinterpret())!!.toKString()
            //set(value) = gtk_notebook_set_tab_label_text(tabs.gtkWidget.reinterpret(), container.reinterpret(), value)

        override fun add(view: View) {
            container = view.gtkWidget.reinterpret()
            gtk_notebook_append_page(tabs.gtkWidget.reinterpret(), view.gtkWidget, gtk_label_new("thingggg"))
        }
    }

    actual inline fun add(page: Page) {
        //pages.add(page)
    }
}