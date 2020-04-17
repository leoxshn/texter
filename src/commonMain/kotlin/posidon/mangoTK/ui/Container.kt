package posidon.mangoTK.ui

import posidon.mangoTK.util.Bitmap

/**
 * Everything that can contain ui elements inherits this
 */
expect abstract class Container {
    fun add(view: View)
}

/**
 * functions for creating the ui
 */

inline fun Container.button(noinline init: Button.() -> Unit) = Button(init).also { add(it) }
inline fun Container.button(text: String, noinline init: Button.() -> Unit) = Button(init).also { add(it); it.text = text }

inline fun Container.button(bitmap: Bitmap, noinline init: ImageButton.() -> Unit) = ImageButton(init).also { add(it); it.bitmap = bitmap }

inline fun Container.text(noinline init: TextView.() -> Unit) = TextView(init).also { add(it) }
inline fun Container.text(text: String, noinline init: TextView.() -> Unit) = TextView(init).also { add(it); it.text = text }
inline fun Container.text(text: String) = TextView { this.text = text }.also { add(it) }

inline fun Container.image(noinline init: ImageView.() -> Unit) = ImageView(init).also { add(it) }
inline fun Container.image(bitmap: Bitmap, noinline init: ImageView.() -> Unit) = ImageView(init).also { add(it); it.bitmap = bitmap }
inline fun Container.image(bitmap: Bitmap) = ImageView().also { add(it); it.bitmap = bitmap }

inline fun Container.linearLayout(orientation: Orientation = Orientation.VERTICAL, noinline init: LinearLayout.() -> Unit) = LinearLayout(orientation, init).also { add(it) }

inline fun Container.tabs(noinline init: TabsView.() -> Unit) = TabsView(init).also { add(it) }
inline fun Container.tabs() = TabsView{}.also { add(it) }

inline fun Container.tree(noinline init: TreeView.() -> Unit) = TreeView(init).also { add(it) }