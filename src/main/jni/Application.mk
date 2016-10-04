APP_ABI := all
# If APP_PLATFORM set to 24 or less then 23 - then app is crashing on Android 6 with "java.lang.UnsatisfiedLinkError: dlopen failed: cannot locate symbol "__aeabi_memclr4" referenced by "/data/app/.../lib/arm/libsqlcipher.so"""
# See https://github.com/android-ndk/ndk/issues/126 for details.
APP_PLATFORM=android-23