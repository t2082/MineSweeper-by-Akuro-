package ms.model;

public class MSArrayCache {
	//Cache
		private int w_cache = 0;
		private int h_cache = 0;
		private int m_cache = 0;
		

		public MSArrayCache(int w, int h, int m) {
			this.w_cache = w;
			this.h_cache = h;
			this.m_cache = m;
		}

		public int getW_cache() {
			return w_cache;
		}

		public void setW_cache(int w_cache) {
			this.w_cache = w_cache;
		}

		public int getH_cache() {
			return h_cache;
		}

		public void setH_cache(int h_cache) {
			this.h_cache = h_cache;
		}

		public int getM_cache() {
			return m_cache;
		}

		public void setM_cache(int m_cache) {
			this.m_cache = m_cache;
		}
		
		
		
}
