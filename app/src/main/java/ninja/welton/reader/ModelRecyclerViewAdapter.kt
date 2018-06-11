package ninja.welton.reader

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ninja.welton.reader.models.AppModel
import org.jetbrains.anko.AnkoLogger

class ModelRecyclerViewAdapter(private val mValues: List<AppModel>, private val layoutView: Int, private val onClick: (View, AppModel) -> Unit)
    : RecyclerView.Adapter<ModelRecyclerViewAdapter.ViewHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutView, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mValues[position].let{model ->

            holder.mItem = model
            holder.mTextView.text = model.name

            //todo: carregar imagem
            model.image?.let {
                //Glide.with(holder.mView).load(mValues[position].image).into(holder.mImageView)
            }

            holder.mView.setOnClickListener{ view -> onClick(view, model) }
        }
    }

    override fun getItemCount() = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTextView = mView.findViewWithTag<View>("text") as TextView
        val mImageView = mView.findViewWithTag<View>("image") as? ImageView
        var mItem: AppModel? = null

        override fun toString(): String {
            return super.toString() + " '" + mItem?.name + "'"
        }
    }
}
