package com.oxsoft.xi

fun <T> T?.guard(throwable: () -> Throwable): T {
    if (this == null) throw throwable()
    else return this
}
