package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString

actual class TabsView actual constructor(init: TabsView.() -> Unit) : View {

    override val gtkWidget: CPointer<GtkWidget> = gtk_notebook_new()!!
    val pages = ArrayList<Page>()

    actual class Page actual constructor(val tabsView: TabsView, name: String): Container() {

        override var container: CPointer<GtkContainer> = tabsView.gtkWidget.reinterpret()

        private val tmpName = name

        actual var name: String
            get() = gtk_notebook_get_tab_label_text(tabsView.gtkWidget.reinterpret(), container.reinterpret())!!.toKString()
            set(value) = gtk_notebook_set_tab_label_text(tabsView.gtkWidget.reinterpret(), container.reinterpret(), value)

        override fun add(view: View) {
            container = view.gtkWidget.reinterpret()
            gtk_notebook_append_page(tabsView.gtkWidget.reinterpret(), view.gtkWidget, gtk_label_new(tmpName))
        }
    }

    actual inline fun add(page: Page) {
        pages.add(page)
    }

    init { init() }
}