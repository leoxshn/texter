package posidon.mangoTK.ui

expect class TreeView(init: TreeView.() -> Unit) : View {

    fun addNode(node: Node)

    class Node(init: Node.() -> Unit) {
        var text: String
    }
}

fun TreeView.node(init: TreeView.Node.() -> Unit) = TreeView.Node(init).also { addNode(it) }
fun TreeView.node(text:String, init: TreeView.Node.() -> Unit) = TreeView.Node(init).also {
    it.text = text
    addNode(it)
}