package posidon.mangoTK.ui

expect class Tabs(init: Tabs.() -> Unit) : View {

    fun add(page: Page)

    class Page(tabs: Tabs, name: String): Container {
        var name: String
    }
}

inline fun Tabs.page(name: String) = Tabs.Page(this, name).also { add(it) }