package com.foodyburger.faking

fun Any.fakingEnabled(): Boolean {
    val fakeAble = this.annotation<FakeAble>()
    return fakeAble?.faking == true
}

fun Any.errorBehavior(): Boolean {
    val fakeImpl = this.annotation<FakeImpl>()
    return fakeImpl?.exposeErrorBehavior == true
}

private inline fun<reified T> Any.annotation(): T? where T : Annotation {
    return this.javaClass.annotations.find {
        x -> x is T
    } as T?
}