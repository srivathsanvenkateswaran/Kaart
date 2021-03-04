package com.example.kaart

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.kaart.data.db.ShoppingDatabase
import com.example.kaart.data.repository.ShoppingRepository
import com.example.kaart.ui.ShoppingList.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KaartApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@KaartApplication))
        bind() from singleton {
            ShoppingDatabase(instance())
        }

        bind() from singleton {
            ShoppingRepository(instance())
        }

        bind() from provider {
            ShoppingViewModelFactory(instance())
        }

    }
}