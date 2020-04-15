package posidon.mangoTK.io

import gtk3.*
import kotlinx.cinterop.*
import posidon.mangoTK.ui.Window

actual object FileChooserDialog {

    actual fun chooseFile(title: String?, window: Window?): File? {
        val chooser = gtk_file_chooser_dialog_new(
            title,
            window?.gtkWindow,
            GtkFileChooserAction.GTK_FILE_CHOOSER_ACTION_OPEN,
            "cancel",
            GTK_RESPONSE_CANCEL,
            "open",
            GTK_RESPONSE_ACCEPT,
            null
        )
        val res = gtk_dialog_run(chooser!!.reinterpret())
        val fileName = if (res == GTK_RESPONSE_ACCEPT) gtk_file_chooser_get_filename(chooser.reinterpret())!!.toKString() else null
        gtk_widget_destroy(chooser)
        return fileName?.let { File(it) }
    }

    actual fun saveFile(title: String?, window: Window?): File? {
        val chooser = gtk_file_chooser_dialog_new(
            title,
            window?.gtkWindow,
            GtkFileChooserAction.GTK_FILE_CHOOSER_ACTION_SAVE,
            "cancel",
            GTK_RESPONSE_CANCEL,
            "open",
            GTK_RESPONSE_ACCEPT,
            null
        )
        val res = gtk_dialog_run(chooser!!.reinterpret())
        var fileName: String? = null
        if (res == GTK_RESPONSE_ACCEPT) {
            fileName = gtk_file_chooser_get_filename(chooser.reinterpret())!!.toKString()
            val err = nativeHeap.alloc<CPointerVar<GError>>().ptr
            g_io_channel_new_file(fileName, "w+", err)
            val error = err.pointed.value?.pointed
            if (error != null) throw Error(error.message!!.toKString())
        }
        gtk_widget_destroy(chooser)
        return fileName?.let { File(it) }
    }
}