package posidon.mangoTK.ui

/**
 * A view with tabs
 */
expect class TabsView(init: TabsView.() -> Unit) : View {

    fun add(page: Page)

    /**
     * Each tab shows it's own page.
     * A page is a Container, so it can contain views
     */
    class Page(tabsView: TabsView, name: String): Container {
        var name: String
    }
}

inline fun TabsView.page(name: String) = TabsView.Page(this, name).also { add(it) }