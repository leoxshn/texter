package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*

actual class Button actual constructor(init: Button.() -> Unit) : View {

    override val gtkWidget = gtk_button_box_new(GtkOrientation.GTK_ORIENTATION_HORIZONTAL)!!
    private val gtkButton = gtk_button_new()!!.also {
        gtk_container_add(gtkWidget.reinterpret(), it)
    }.reinterpret<GtkButton>()

    var onClick: Button.() -> Unit = {}

    actual var text: String
        get() = gtk_button_get_label(gtkButton).toString()
        set(value) {
            gtk_button_set_label(gtkButton, value)
        }

    init {
        val stableRef = StableRef.create(this)
        g_signal_connect_data(gtkButton.reinterpret(), "clicked", staticCFunction { _: CPointer<GtkButton>, ref: gpointer ->
            ref.asStableRef<Button>().get().run { onClick.invoke(this) }
        }.reinterpret(), data = stableRef.asCPointer(), destroy_data = null, connect_flags = 0u)
        stableRef.dispose()
        init()
    }

    actual fun onClick(action: Button.() -> Unit) {
        onClick = action
    }
}