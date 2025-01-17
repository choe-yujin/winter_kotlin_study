package day17.repository

import day17.model.Store

interface StoreRepository {
    suspend fun getStoreInfoList(): List<Store>
}