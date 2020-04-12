package posidon.mangoTK.ui

expect class GtkHeaderBar(init: GtkHeaderBar.() -> Unit) {
    var title: String
    var subtitle: String
    var hasSubtitle: Boolean
    var showCloseBtn: Boolean
}