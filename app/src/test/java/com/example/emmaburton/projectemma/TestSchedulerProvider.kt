package com.example.emmaburton.projectemma

import com.example.emmaburton.projectemma.threading.SchedulerProvider
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider : SchedulerProvider {

    override fun getUiScheduler() = Schedulers.trampoline()

}