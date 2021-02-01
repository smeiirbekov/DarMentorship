package com.sm.lecture4

abstract class EnhancedAnimal: Animal {

    abstract fun enhancedAbility(): String

    override val id: Int = 5

    override fun walk() = "Enhanced walks"

}