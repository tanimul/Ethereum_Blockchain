package com.example.ethereum_blockchain.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ethereum_blockchain.getOrAwaitValue
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class InfoViewModelTest : TestCase() {
    private var viewModel: InfoViewModel = InfoViewModel()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun testInfoViewModel() {
        viewModel.getInfos("738d145faabb1e00cf5a017588a9c0f998318012")
        val result = viewModel.infos.getOrAwaitValue()
        assertTrue(result!=null)

    }


}