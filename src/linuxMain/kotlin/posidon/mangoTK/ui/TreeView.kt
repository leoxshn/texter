package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*

actual class TreeView actual constructor(init: TreeView.() -> Unit): View {
    override val gtkWidget = gtk_tree_view_new()!!

    init {
        val column = gtk_tree_view_column_new()
        gtk_tree_view_append_column(gtkWidget.reinterpret(), column)
        gtk_tree_view_column_set_title(column, "blablabla")
        println("aaaaaaaaaaaaaaaaaaa")
        val type = StableRef.create(gtk_label_get_type())
        println("dfgdfgsfdg")
        //val listStore = gtk_list_store_new(1, "blablblaaaaa")!!
        println("adgdfhdghdfgfh")
        init()
        type.dispose()
    }

    actual fun addNode(node: Node) {

    }

    actual class Node actual constructor(init: Node.() -> Unit) {
        actual var text: String
            get() = TODO("Not yet implemented")
            set(value) {

            }

        init { init() }
    }
}