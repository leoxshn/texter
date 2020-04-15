package posidon.mangoTK.io

import posidon.mangoTK.ui.Window

expect object FileChooserDialog {
    fun chooseFile(title: String? = null, window: Window? = null): File?
    fun saveFile(title: String? = null, window: Window? = null): File?
}