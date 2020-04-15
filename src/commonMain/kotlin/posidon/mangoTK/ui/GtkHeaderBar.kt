package posidon.mangoTK.ui

/**
 * The class for the Gtk headerbar. Only works on linux.
 */
expect class GtkHeaderBar(init: GtkHeaderBar.() -> Unit) {
    var title: String
    var subtitle: String
    var hasSubtitle: Boolean
    var showCloseBtn: Boolean

    abstract class Side(headerBar: GtkHeaderBar, init: Side.() -> Unit): Container
    class StartSide(headerBar: GtkHeaderBar, init: Side.() -> Unit): Side
    class EndSide(headerBar: GtkHeaderBar, init: Side.() -> Unit): Side
}

fun GtkHeaderBar.start(init: GtkHeaderBar.Side.() -> Unit) { GtkHeaderBar.StartSide(this, init) }
fun GtkHeaderBar.end(init: GtkHeaderBar.Side.() -> Unit) { GtkHeaderBar.EndSide(this, init) }