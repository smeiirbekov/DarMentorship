package com.sm.testapp

class ThreadSafeSingleton {

    companion object {

        @Volatile
        private var instance: ThreadSafeSingleton? = null

        @Synchronized
        fun getInstance(): ThreadSafeSingleton {

            if (instance == null) {
                instance = ThreadSafeSingleton()
            }
            return instance!!
        }

    }



    //asd asd

}