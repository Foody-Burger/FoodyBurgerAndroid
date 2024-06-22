package com.foodyburger.faking

import FAKING_ERROR_BEHAVIOR_BOOLEAN

/**
 * Helper annotation to be able switch between
 * _success_ and _error_ states in fake services.
 * @param exposeErrorBehavior
 *  - `True` to expose error result in all methods.
 *  - `False` to expose success result in all methods.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class FakeImpl(val exposeErrorBehavior: Boolean = FAKING_ERROR_BEHAVIOR_BOOLEAN)
