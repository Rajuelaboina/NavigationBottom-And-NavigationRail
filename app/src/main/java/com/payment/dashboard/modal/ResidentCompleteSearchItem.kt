package com.payment.dashboard.modal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "resident")
data class ResidentCompleteSearchItem(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    @SerializedName("ID")
    val ID: Int?,


    @ColumnInfo(name = "ProgramId")
    @SerializedName("ProgramID")
    val ProgramID: Long?,

    @SerializedName("Location")
    @ColumnInfo(name = "Location")
    val Location: String?,


    @ColumnInfo(name = "ProviderName")
    @SerializedName("Provider_Name")
    val Provider_Name: String?,


    @ColumnInfo(name = "Pgy")
    @SerializedName("PGY")
    val PGY: String?,


    @ColumnInfo(name = "ClassOf")
    @SerializedName("ClassOf")
    val ClassOf: String?,


    @ColumnInfo(name = "UGCollege")
    @SerializedName("UnderGraduateCollege")
    val UnderGraduateCollege: String?,


    @ColumnInfo(name = "Mschool")
    @SerializedName("MedicalSchool")
    val MedicalSchool: String?,


    @ColumnInfo(name = "Internship")
    @SerializedName("Internship")
    val Internship: String?,


    @ColumnInfo(name = "Major")
    @SerializedName("Major")
    val Major: String?,


    @ColumnInfo(name = "Fellowship")
    @SerializedName("Fellowship")
    val Fellowship: String?,


    @ColumnInfo(name = "HomeTown")
    @SerializedName("HomeTown")
    val HomeTown: String?,


    @ColumnInfo(name = "MailId")
    @SerializedName("MailID")
    val MailID: String?,

    @SerializedName("PhoneNo")
    @ColumnInfo(name = "PhoneNo")
    val PhoneNo: String?,


    @ColumnInfo(name = "Misc")
    @SerializedName("Misc")
    val Misc: String?,


    @ColumnInfo(name = "Photo")
    @SerializedName("Photo")
    val Photo: String?,


    @ColumnInfo(name = "FileName")
    @SerializedName("FileName")
    val FileName: String?,


    @ColumnInfo(name = "TimeStamp")
    @SerializedName("TimeStamp")
    val TimeStamp: String?,


    @ColumnInfo(name = "ProgramName")
    @SerializedName("ProgramName")
    val ProgramName: String?,


    @ColumnInfo(name = "Speciality")
    @SerializedName("Speciality")
    val Speciality: String?,


    @ColumnInfo(name = "PLocation")
    @SerializedName("ProgramLocation")
    val ProgramLocation: String?

): Serializable