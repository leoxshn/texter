package posidon.mangoTK.ui

/**
 * The class for the Gtk headerbar. Only works on linux.
 */
expect class GtkHeaderBar(init: GtkHeaderBar.() -> Unit) {
    var title: String
    var subtitle: String
    var hasSubtitle: Boolean
    var showCloseBtn: Boolean
}