package com.vvwxx.bangkit.mynotepadkw

import android.content.Context

internal object FileHelper {

    fun writeToFIle(fileModel: FileModel, context: Context) {
        context.openFileOutput(fileModel.filename, Context.MODE_PRIVATE).use {
            it.write(fileModel.data?.toByteArray())
        }
    }

    fun readFromFile(context: Context, filename: String): FileModel {
        val fileModel = FileModel()
        fileModel.filename = filename
        fileModel.data = context.openFileInput(filename).bufferedReader().useLines { lines ->
            lines.fold("") { some, text ->
                """
                    $some
                    $text
                """.trimIndent()
            }
        }
        return fileModel
    }
}