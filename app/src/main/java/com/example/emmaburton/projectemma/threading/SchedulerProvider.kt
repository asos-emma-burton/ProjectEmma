package com.example.emmaburton.projectemma.threading

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun getUiScheduler(): Scheduler
}