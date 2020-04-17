package posidon.mangoTK.ui

/**
 * A view with tabs
 */
expect class TabsView(init: TabsView.() -> Unit) : View {

    fun add(tab: Tab)

    /**
     * A tab is a Container, so it can contain views (only one)
     */
    class Tab(tabsView: TabsView, name: String): Container {
        var name: String
    }
}

inline fun TabsView.tab(name: String) = TabsView.Tab(this, name).also { add(it) }