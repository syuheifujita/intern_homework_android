package com.example.intern_anrdoid_2020.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intern_anrdoid_2020.R
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import com.example.intern_anrdoid_2020.view.QiitaListViewAdapter.QiitaListViewHolder
import kotlinx.android.synthetic.main.row_qiita_list.view.*
import kotlinx.android.synthetic.main.row_qiita_list.view.iv_user_image
import kotlinx.android.synthetic.main.row_qiita_list.view.tv_qiita_lgtm_counter
import kotlinx.android.synthetic.main.row_qiita_list.view.tv_qiita_title
import kotlinx.android.synthetic.main.row_qiita_list_question1.view.*

class Question1QiitaListViewAdapter(private val listData: List<QiitaArticleResponse>?) : RecyclerView.Adapter<Question1QiitaListViewAdapter.Question1QiitaListViewHolder>() {

    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClickListener(item: QiitaArticleResponse)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class Question1QiitaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivQiitaImage: ImageView
        val tvQiitaTitle: TextView
        val tvQiitaLgtm: TextView

        init {
            ivQiitaImage = itemView.iv_user_image_question1
            tvQiitaTitle = itemView.tv_qiita_title_question1
            tvQiitaLgtm = itemView.tv_qiita_lgtm_counter_question1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Question1QiitaListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_qiita_list_question1, parent, false)
        return Question1QiitaListViewHolder(v)
    }

    override fun onBindViewHolder(holder: Question1QiitaListViewHolder, position: Int) {
        listData?.let {
            val qiitaArticleResponse = listData[position]
            holder.tvQiitaTitle.text = qiitaArticleResponse.title
            holder.tvQiitaLgtm.text = qiitaArticleResponse.likesCount.toString()
            Glide.with(holder.ivQiitaImage.context).load(qiitaArticleResponse.user?.profileImageUrl).into(holder.ivQiitaImage)
            holder.itemView.setOnClickListener {
                if (position == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                listener.onItemClickListener(qiitaArticleResponse)
            }
        }
    }

    override fun getItemCount(): Int {
        listData?.let {
            return listData.size
        }
        return 0
    }
}