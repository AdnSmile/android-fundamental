package com.vvwxx.bangkit.mynotepadkw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vvwxx.bangkit.mynotepadkw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNew.setOnClickListener(this)
        binding.buttonOpen.setOnClickListener(this)
        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_new -> newFile()
            R.id.button_open -> showList()
            R.id.button_save -> saveFile()
        }
    }

    private fun newFile() {
        binding.editFile.setText("")
        binding.editTitle.setText("")
        toastUp("clearing file")
    }

    private fun  showList() {
        val items = fileList()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih file yang diinginkan")
        builder.setItems(items) { _, item -> loadData(items[item].toString()) }
        builder.create().show()
    }

    private fun loadData(title: String) {
        val fileModel = FileHelper.readFromFile(this, title)
        binding.editTitle.setText(fileModel.filename)
        binding.editFile.setText(fileModel.data)
        toastUp("Loading ${fileModel.filename} data")
    }

    private fun saveFile() {
        when {
            binding.editTitle.text.toString().isEmpty() -> toastUp("Title harus diisi terlebih dahulu")
            binding.editFile.text.toString().isEmpty() -> toastUp("Konten harus diisi terlebih dahulu")
            else -> {
                val title = binding.editTitle.text.toString()
                val text = binding.editFile.text.toString()
                val fileModel = FileModel()
                fileModel.filename = title
                fileModel.data =text
                FileHelper.writeToFIle(fileModel, this)
                toastUp("Saving ${fileModel.filename} file")
            }
        }
    }

    private fun toastUp(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}