package com.example.emmaburton.projectemma.threading

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class RxSchedulerProvider : SchedulerProvider {

    override fun getUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

}