package com.foodyburger.faking

import USE_FAKING_BOOLEAN

/**
 *
 */
@Target(AnnotationTarget.FUNCTION)
annotation class FakeAble(val faking: Boolean = USE_FAKING_BOOLEAN)
