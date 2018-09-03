package com.porify.kotlin.annotation

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotaion

@BindingAnnotaion
annotation class MyBinding