package com.example.mvvmrunningapp.repositories

import com.example.mvvmrunningapp.db.Run
import com.example.mvvmrunningapp.db.RunDAO
import javax.inject.Inject

public class MainRepository @Inject constructor(val runDAO: RunDAO)
{
    public suspend fun insertRun(run:Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run:Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunSortedByDate()

    fun getAllRunsSortedByDistance() = runDAO.getAllRunSortedByDistance()

    fun getAllRunsSortedByTimeInMillis() = runDAO.getAllRunSortedByTimeMillis()

    fun getAllRunsSortedByAvgSpeed  () = runDAO.getAllRunSortedByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurned() = runDAO.getAllRunSortedByCalorieBurnt()

    fun getTotalAvgSpeed() = runDAO.getTotalAverageSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurnt()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()

}