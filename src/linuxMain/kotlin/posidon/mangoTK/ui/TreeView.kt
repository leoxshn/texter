package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*

actual class TreeView actual constructor(init: TreeView.() -> Unit): View {
    override val gtkWidget = gtk_tree_view_new()!!
    val model: CPointer<GtkTreeStore>
    val cellRenderer = gtk_cell_renderer_text_new()

    init {
        val column = gtk_tree_view_column_new()
        gtk_tree_view_append_column(gtkWidget.reinterpret(), column)
        gtk_tree_view_column_set_title(column, "blablabla")
        gtk_tree_view_column_pack_start(column, cellRenderer, 1)
        gtk_tree_view_column_add_attribute(column, cellRenderer, "text", 0)
        println("aaaaaaaaaaaaaaaaaaa")
        println("dfgdfgsfdg")
        model = gtk_tree_store_new(1, G_TYPE_STRING)!!
        println("adgdfhdghdfgfh")
        gtk_tree_view_set_model(gtkWidget.reinterpret(), model.reinterpret())
        init()
    }

    actual fun addNode(node: Node) {
        val parentIter: CPointer<GtkTreeIter> = nativeHeap.alloc<GtkTreeIter>().ptr
        val iter: CPointer<GtkTreeIter> = nativeHeap.alloc<GtkTreeIter>().ptr
        gtk_tree_model_get_iter_first(model.reinterpret(), parentIter)
        gtk_tree_model_get_iter(model.reinterpret(), parentIter, gtk_tree_path_new())
        println("sdddddddddd")
        gtk_tree_store_append(model, iter, parentIter)
        println("1234567890987654321")
        println("777777777444444444888888")
        gtk_tree_store_set(model, iter, 0, "sssss", -1)
        println("22222222222")
        nativeHeap.free(iter)
        nativeHeap.free(parentIter)
    }

    actual class Node actual constructor(init: Node.() -> Unit) {
        actual var text: String
            get() = TODO("Not yet implemented")
            set(value) {

            }

        init { init() }
    }
}