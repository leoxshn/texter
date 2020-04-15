package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*
import posidon.mangoTK.util.Bitmap

actual class ImageButton actual constructor(init: ImageButton.() -> Unit) : View {

    override val gtkWidget = gtk_button_box_new(GtkOrientation.GTK_ORIENTATION_HORIZONTAL)!!
    private val gtkButton = gtk_button_new()!!.also {
        gtk_container_add(gtkWidget.reinterpret(), it)
    }.reinterpret<GtkButton>()

    var onClick: ImageButton.() -> Unit = {}

    actual var bitmap: Bitmap
        get() = Bitmap(gtk_image_get_pixbuf(gtk_button_get_image(gtkButton)!!.reinterpret()))
        set(value) {
            gtk_button_set_image(gtkButton, gtk_image_new_from_pixbuf(value.pixbuf))
        }

    init {
        val stableRef = StableRef.create(this)
        g_signal_connect_data(gtkButton.reinterpret(), "clicked", staticCFunction { _: CPointer<GtkButton>, ref: gpointer ->
            ref.asStableRef<ImageButton>().get().run { onClick.invoke(this) }
        }.reinterpret(), data = stableRef.asCPointer(), destroy_data = null, connect_flags = 0u)
        stableRef.dispose()
        init()
    }

    actual fun onClick(action: ImageButton.() -> Unit) {
        onClick = action
    }
}