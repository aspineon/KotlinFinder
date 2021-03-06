package com.kotlinconf.library.feature.mainMap.di

import com.kotlinconf.library.feature.mainMap.presentation.MapViewModel
import com.kotlinconf.library.feature.mainMap.presentation.SplashViewModel
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.permissions.PermissionsController
import com.kotlinconf.library.domain.di.DomainFactory


class MapViewModelFactory(
    private val domainFactory: DomainFactory
) {

    fun createMapViewModel(
        eventsDispatcher: EventsDispatcher<MapViewModel.EventsListener>,
        permissionsController: PermissionsController
    ): MapViewModel {
        return MapViewModel(
            collectedSpotsRepository = this.domainFactory.collectedSpotsRepository,
            spotSearchRepository = this.domainFactory.spotSearchRepository,
            gameDataRepository = this.domainFactory.gameDataRepository,
            eventsDispatcher = eventsDispatcher,
            permissionsController = permissionsController
        )
    }

    fun createSplashViewModel(
        eventsDispatcher: EventsDispatcher<SplashViewModel.EventsListener>
    ): SplashViewModel {
        return SplashViewModel(
            eventsDispatcher = eventsDispatcher,
            gameDataRepository = this.domainFactory.gameDataRepository
        )
    }
}