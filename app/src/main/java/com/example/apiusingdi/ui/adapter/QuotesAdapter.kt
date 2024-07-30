package com.example.apiusingdi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiusingdi.R
import com.example.apiusingdi.domain.model.Quote

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {

    private var quotes: List<Quote> = emptyList()

    fun setQuotes(newQuotes: List<Quote>) {
        quotes = newQuotes
        notifyDataSetChanged()
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val quoteTextView: TextView = itemView.findViewById(R.id.quoteTextView)

        fun bind(quote: Quote) {
            authorTextView.text = quote.author
            quoteTextView.text = quote.quote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(quotes[position])
    }
}