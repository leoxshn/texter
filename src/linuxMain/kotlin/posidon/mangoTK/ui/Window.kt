package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.*
import posidon.texter.AppInfo

actual class Window actual constructor(val init: Window.() -> Unit) : Container() {

    lateinit var gtkWindow: CPointer<GtkWindow>
    override val container get() = gtkWindow.reinterpret<GtkContainer>()

    init {
        val app = gtk_application_new(AppInfo.id, G_APPLICATION_FLAGS_NONE)!!
        val stableRef = StableRef.create(this)
        g_signal_connect_data(app.reinterpret(), "activate", staticCFunction(::activate).reinterpret(), data = stableRef.asCPointer(), destroy_data = null, connect_flags = 0u)
        memScoped { g_application_run(app.reinterpret(), 0, null) }
        g_object_unref(app)
        stableRef.dispose()
    }

    actual fun close() = gtk_widget_destroy(gtkWindow.reinterpret())

    actual var title: String = ""
        set(value) {
            field = value
            gtk_window_set_title(gtkWindow, value)
        }
}

private fun activate(app: CPointer<GtkApplication>, windowPointer: gpointer) =
    windowPointer.asStableRef<Window>().get().run {
        val windowWidget = gtk_application_window_new(app)!!
        gtkWindow = windowWidget.reinterpret()
        init()

        gtk_window_set_default_size(gtkWindow, 200, 200)

        gtk_widget_show_all(windowWidget)
    }