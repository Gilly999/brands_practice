package bands_package.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class ImageWithTitle {

	@Inject
	@Optional
	private String text;
	@Inject
	@Optional
	private String image;
	@Inject
	@Optional
	private String alt;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@PostConstruct
	public String getJson() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("text", this.getText());
			jsonObj.put("image", this.getImage());
			jsonObj.put("alt", getAlt());
			jsonObj.put("key", this.getAlt());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.getMessage().toString();
		}
		return jsonObj.toString();

	}

}