# Texter

The [old texter](https://github.com/leoxshn/texter_old) was built on very old java frameworks (awt & swing), they were slow, buggy, hard to work with... This one's gonna be very similar to old texter, but it will use Gtk of Linux (other platforms not yet supported), so it will be less themable, but it will look more like other apps on your OS.

Obviously, I had to use Kotlin, so it might take some time for me to make this an actual text editor

I'm not planning to support use the win32 framework, bacause it looks very outdated.
I'd rather just use javaFX or even swt and get an acceptable UI.

Platforms that I want to support in the future:
 - Java Desktop
 - Mac OS
 - Android & Chrome OS
 - Maybe, just maybe UWP

### MangoTK
Mango Toolkit is a part of the source code that will eventually become a separate library. It's responsible for all platform-dependant stuff (just ui for now).
Why is Mango the name? because it's a tasty fruit and I like it.
