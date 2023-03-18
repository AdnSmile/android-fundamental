package com.vvwxx.bangkit.myunittest

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mockCuboidModel: ICuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0

    @Before
    fun before() {
        mockCuboidModel = mock(ICuboidModel::class.java)
        mainViewModel = MainViewModel(mockCuboidModel)
    }

    @Test
    fun testVolume() {
        mockCuboidModel = CuboidModel()
        mainViewModel = MainViewModel(mockCuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}