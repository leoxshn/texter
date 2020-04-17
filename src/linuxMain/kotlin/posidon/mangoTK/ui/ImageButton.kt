package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*
import posidon.mangoTK.util.Bitmap

actual class ImageButton actual constructor(init: ImageButton.() -> Unit) : View {

    override val gtkWidget = gtk_button_new()!!

    var onClick: ImageButton.() -> Unit = {}

    actual var bitmap: Bitmap
        get() = Bitmap(gtk_image_get_pixbuf(gtk_button_get_image(gtkWidget.reinterpret())!!.reinterpret()))
        set(value) {
            gtk_button_set_image(gtkWidget.reinterpret(), gtk_image_new_from_pixbuf(value.pixbuf))
        }

    init {
        val stableRef = StableRef.create(this)
        g_signal_connect_data(gtkWidget.reinterpret(), "clicked", staticCFunction { _: CPointer<GtkButton>, ref: gpointer ->
            ref.asStableRef<ImageButton>().get().run { onClick.invoke(this) }
        }.reinterpret(), data = stableRef.asCPointer(), destroy_data = null, connect_flags = 0u)
        stableRef.dispose()
        init()
    }

    actual fun onClick(action: ImageButton.() -> Unit) {
        onClick = action
    }
}