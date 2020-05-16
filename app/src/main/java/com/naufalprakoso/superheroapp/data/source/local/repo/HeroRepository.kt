package com.naufalprakoso.superheroapp.data.source.local.repo

import com.naufalprakoso.superheroapp.data.source.local.db.HeroDao

class HeroRepository(private val heroDao: HeroDao) {
    companion object {
        private var INSTANCE: HeroRepository? = null

        fun getInstance(heroDao: HeroDao): HeroRepository? {
            if (INSTANCE == null) {
                INSTANCE = HeroRepository(heroDao)
            }
            return INSTANCE
        }
    }
}