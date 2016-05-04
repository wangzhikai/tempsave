package tea.looca;
/**
 * @author Zhikai Wang/www.heteroclinic.net
 * You can utilize this program at will.
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//TODO Why there is no AD0
public class MonthEndWeekEnd {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// get the beginning of time, it is the design of modern operating
		// system 0 timestamp.
		cal.setTimeInMillis(0l);
		Date d = cal.getTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("G MM/dd/yyyy EEE");
		String str = dateFormatter.format(d);
		// System.out.println(str);
		// 12/31/1969 Wed
		cal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		d = cal.getTime();
		str = dateFormatter.format(d);
		// System.out.println(str);
		// 12/31/1969 Wed

		int count = 0;
		
		// WHILE year <= 3000
		int year = cal.get(Calendar.YEAR);
		//while (year <= 30000){
		while (count <= 4000){
			// mostly Saturday is considered to be weekend, I personally prefer
			// Friday.
			// get the first day of cal's month firstDayOfCalMonth
			Calendar firstDayOfCalMonth = Calendar.getInstance();
			firstDayOfCalMonth.setTimeInMillis(cal.getTimeInMillis());
			firstDayOfCalMonth.set(Calendar.DAY_OF_MONTH, firstDayOfCalMonth.getActualMinimum(Calendar.DAY_OF_MONTH));
			// d = firstDayOfCalMonth.getTime();
			// str = dateFormatter.format(d);
			// System.out.println(str);

			// increase firstDayOfCalMonth by one month firstDayOfNextMonth
			//firstDayOfCalMonth.add(Calendar.MONTH, -1);
			firstDayOfCalMonth.add(Calendar.MONTH, -1);
			
			
			Calendar firstDayOfNextMonth = Calendar.getInstance();
			firstDayOfNextMonth.setTimeInMillis(firstDayOfCalMonth.getTimeInMillis());
			// d = firstDayOfNextMonth.getTime();
			// str = dateFormatter.format(d);
			// System.out.println(str);

			// get the lastDayOfNextMonth
			Calendar lastDayOfNextMonth = Calendar.getInstance();
			lastDayOfNextMonth.setTimeInMillis(firstDayOfNextMonth.getTimeInMillis());
			lastDayOfNextMonth.set(Calendar.DAY_OF_MONTH, lastDayOfNextMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
			d = lastDayOfNextMonth.getTime();
			str = dateFormatter.format(d);
			//System.out.println(str);			
			//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
			if (lastDayOfNextMonth.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				System.out.println(str);	
				count++;
			}
			// assign lastDayOfNextMonth to cal
			cal = lastDayOfNextMonth;

			year = cal.get(Calendar.YEAR);
			
		}

		System.out.println("count = " + count );
	}

}

/*
07/31/1970 Fri
04/30/1971 Fri
12/31/1971 Fri
03/31/1972 Fri
06/30/1972 Fri
08/31/1973 Fri
11/30/1973 Fri
05/31/1974 Fri
01/31/1975 Fri
02/28/1975 Fri
10/31/1975 Fri
04/30/1976 Fri
12/31/1976 Fri
09/30/1977 Fri
03/31/1978 Fri
06/30/1978 Fri
08/31/1979 Fri
11/30/1979 Fri
02/29/1980 Fri
10/31/1980 Fri
07/31/1981 Fri
04/30/1982 Fri
12/31/1982 Fri
09/30/1983 Fri
08/31/1984 Fri
11/30/1984 Fri
05/31/1985 Fri
01/31/1986 Fri
02/28/1986 Fri
10/31/1986 Fri
07/31/1987 Fri
09/30/1988 Fri
03/31/1989 Fri
06/30/1989 Fri
08/31/1990 Fri
11/30/1990 Fri
05/31/1991 Fri
01/31/1992 Fri
07/31/1992 Fri
04/30/1993 Fri
12/31/1993 Fri
09/30/1994 Fri
03/31/1995 Fri
06/30/1995 Fri
05/31/1996 Fri
01/31/1997 Fri
02/28/1997 Fri
10/31/1997 Fri
07/31/1998 Fri
04/30/1999 Fri
12/31/1999 Fri
03/31/2000 Fri
06/30/2000 Fri
08/31/2001 Fri
11/30/2001 Fri
05/31/2002 Fri
01/31/2003 Fri
02/28/2003 Fri
10/31/2003 Fri
04/30/2004 Fri
12/31/2004 Fri
09/30/2005 Fri
03/31/2006 Fri
06/30/2006 Fri
08/31/2007 Fri
11/30/2007 Fri
02/29/2008 Fri
10/31/2008 Fri
07/31/2009 Fri
04/30/2010 Fri
12/31/2010 Fri
09/30/2011 Fri
08/31/2012 Fri
11/30/2012 Fri
05/31/2013 Fri
01/31/2014 Fri
02/28/2014 Fri
10/31/2014 Fri
07/31/2015 Fri
09/30/2016 Fri
03/31/2017 Fri
06/30/2017 Fri
08/31/2018 Fri
11/30/2018 Fri
05/31/2019 Fri
01/31/2020 Fri
07/31/2020 Fri
04/30/2021 Fri
12/31/2021 Fri
09/30/2022 Fri
03/31/2023 Fri
06/30/2023 Fri
05/31/2024 Fri
01/31/2025 Fri
02/28/2025 Fri
10/31/2025 Fri
07/31/2026 Fri
04/30/2027 Fri
12/31/2027 Fri
03/31/2028 Fri
06/30/2028 Fri
08/31/2029 Fri
11/30/2029 Fri
05/31/2030 Fri
01/31/2031 Fri
02/28/2031 Fri
10/31/2031 Fri
04/30/2032 Fri
12/31/2032 Fri
09/30/2033 Fri
03/31/2034 Fri
06/30/2034 Fri
08/31/2035 Fri
11/30/2035 Fri
02/29/2036 Fri
10/31/2036 Fri
07/31/2037 Fri
04/30/2038 Fri
12/31/2038 Fri
09/30/2039 Fri
08/31/2040 Fri
11/30/2040 Fri
05/31/2041 Fri
01/31/2042 Fri
02/28/2042 Fri
10/31/2042 Fri
07/31/2043 Fri
09/30/2044 Fri
03/31/2045 Fri
06/30/2045 Fri
08/31/2046 Fri
11/30/2046 Fri
05/31/2047 Fri
01/31/2048 Fri
07/31/2048 Fri
04/30/2049 Fri
12/31/2049 Fri
09/30/2050 Fri
03/31/2051 Fri
06/30/2051 Fri
05/31/2052 Fri
01/31/2053 Fri
02/28/2053 Fri
10/31/2053 Fri
07/31/2054 Fri
04/30/2055 Fri
12/31/2055 Fri
03/31/2056 Fri
06/30/2056 Fri
08/31/2057 Fri
11/30/2057 Fri
05/31/2058 Fri
01/31/2059 Fri
02/28/2059 Fri
10/31/2059 Fri
04/30/2060 Fri
12/31/2060 Fri
09/30/2061 Fri
03/31/2062 Fri
06/30/2062 Fri
08/31/2063 Fri
11/30/2063 Fri
02/29/2064 Fri
10/31/2064 Fri
07/31/2065 Fri
04/30/2066 Fri
12/31/2066 Fri
09/30/2067 Fri
08/31/2068 Fri
11/30/2068 Fri
05/31/2069 Fri
01/31/2070 Fri
02/28/2070 Fri
10/31/2070 Fri
07/31/2071 Fri
09/30/2072 Fri
03/31/2073 Fri
06/30/2073 Fri
08/31/2074 Fri
11/30/2074 Fri
05/31/2075 Fri
01/31/2076 Fri
07/31/2076 Fri
04/30/2077 Fri
12/31/2077 Fri
09/30/2078 Fri
03/31/2079 Fri
06/30/2079 Fri
05/31/2080 Fri
01/31/2081 Fri
02/28/2081 Fri
10/31/2081 Fri
07/31/2082 Fri
04/30/2083 Fri
12/31/2083 Fri
03/31/2084 Fri
06/30/2084 Fri
08/31/2085 Fri
11/30/2085 Fri
05/31/2086 Fri
01/31/2087 Fri
02/28/2087 Fri
10/31/2087 Fri
04/30/2088 Fri
12/31/2088 Fri
09/30/2089 Fri
03/31/2090 Fri
06/30/2090 Fri
08/31/2091 Fri
11/30/2091 Fri
02/29/2092 Fri
10/31/2092 Fri
07/31/2093 Fri
04/30/2094 Fri
12/31/2094 Fri
09/30/2095 Fri
08/31/2096 Fri
11/30/2096 Fri
05/31/2097 Fri
01/31/2098 Fri
02/28/2098 Fri
10/31/2098 Fri
07/31/2099 Fri
04/30/2100 Fri
12/31/2100 Fri
09/30/2101 Fri
03/31/2102 Fri
06/30/2102 Fri
08/31/2103 Fri
11/30/2103 Fri
02/29/2104 Fri
10/31/2104 Fri
07/31/2105 Fri
04/30/2106 Fri
12/31/2106 Fri
09/30/2107 Fri
08/31/2108 Fri
11/30/2108 Fri
05/31/2109 Fri
01/31/2110 Fri
02/28/2110 Fri
10/31/2110 Fri
07/31/2111 Fri
09/30/2112 Fri
03/31/2113 Fri
06/30/2113 Fri
08/31/2114 Fri
11/30/2114 Fri
05/31/2115 Fri
01/31/2116 Fri
07/31/2116 Fri
04/30/2117 Fri
12/31/2117 Fri
09/30/2118 Fri
03/31/2119 Fri
06/30/2119 Fri
05/31/2120 Fri
01/31/2121 Fri
02/28/2121 Fri
10/31/2121 Fri
07/31/2122 Fri
04/30/2123 Fri
12/31/2123 Fri
03/31/2124 Fri
06/30/2124 Fri
08/31/2125 Fri
11/30/2125 Fri
05/31/2126 Fri
01/31/2127 Fri
02/28/2127 Fri
10/31/2127 Fri
04/30/2128 Fri
12/31/2128 Fri
09/30/2129 Fri
03/31/2130 Fri
06/30/2130 Fri
08/31/2131 Fri
11/30/2131 Fri
02/29/2132 Fri
10/31/2132 Fri
07/31/2133 Fri
04/30/2134 Fri
12/31/2134 Fri
09/30/2135 Fri
08/31/2136 Fri
11/30/2136 Fri
05/31/2137 Fri
01/31/2138 Fri
02/28/2138 Fri
10/31/2138 Fri
07/31/2139 Fri
09/30/2140 Fri
03/31/2141 Fri
06/30/2141 Fri
08/31/2142 Fri
11/30/2142 Fri
05/31/2143 Fri
01/31/2144 Fri
07/31/2144 Fri
04/30/2145 Fri
12/31/2145 Fri
09/30/2146 Fri
03/31/2147 Fri
06/30/2147 Fri
05/31/2148 Fri
01/31/2149 Fri
02/28/2149 Fri
10/31/2149 Fri
07/31/2150 Fri
04/30/2151 Fri
12/31/2151 Fri
03/31/2152 Fri
06/30/2152 Fri
08/31/2153 Fri
11/30/2153 Fri
05/31/2154 Fri
01/31/2155 Fri
02/28/2155 Fri
10/31/2155 Fri
04/30/2156 Fri
12/31/2156 Fri
09/30/2157 Fri
03/31/2158 Fri
06/30/2158 Fri
08/31/2159 Fri
11/30/2159 Fri
02/29/2160 Fri
10/31/2160 Fri
07/31/2161 Fri
04/30/2162 Fri
12/31/2162 Fri
09/30/2163 Fri
08/31/2164 Fri
11/30/2164 Fri
05/31/2165 Fri
01/31/2166 Fri
02/28/2166 Fri
10/31/2166 Fri
07/31/2167 Fri
09/30/2168 Fri
03/31/2169 Fri
06/30/2169 Fri
08/31/2170 Fri
11/30/2170 Fri
05/31/2171 Fri
01/31/2172 Fri
07/31/2172 Fri
04/30/2173 Fri
12/31/2173 Fri
09/30/2174 Fri
03/31/2175 Fri
06/30/2175 Fri
05/31/2176 Fri
01/31/2177 Fri
02/28/2177 Fri
10/31/2177 Fri
07/31/2178 Fri
04/30/2179 Fri
12/31/2179 Fri
03/31/2180 Fri
06/30/2180 Fri
08/31/2181 Fri
11/30/2181 Fri
05/31/2182 Fri
01/31/2183 Fri
02/28/2183 Fri
10/31/2183 Fri
04/30/2184 Fri
12/31/2184 Fri
09/30/2185 Fri
03/31/2186 Fri
06/30/2186 Fri
08/31/2187 Fri
11/30/2187 Fri
02/29/2188 Fri
10/31/2188 Fri
07/31/2189 Fri
04/30/2190 Fri
12/31/2190 Fri
09/30/2191 Fri
08/31/2192 Fri
11/30/2192 Fri
05/31/2193 Fri
01/31/2194 Fri
02/28/2194 Fri
10/31/2194 Fri
07/31/2195 Fri
09/30/2196 Fri
03/31/2197 Fri
06/30/2197 Fri
08/31/2198 Fri
11/30/2198 Fri
05/31/2199 Fri
01/31/2200 Fri
02/28/2200 Fri
10/31/2200 Fri
07/31/2201 Fri
04/30/2202 Fri
12/31/2202 Fri
09/30/2203 Fri
08/31/2204 Fri
11/30/2204 Fri
05/31/2205 Fri
01/31/2206 Fri
02/28/2206 Fri
10/31/2206 Fri
07/31/2207 Fri
09/30/2208 Fri
03/31/2209 Fri
06/30/2209 Fri
08/31/2210 Fri
11/30/2210 Fri
05/31/2211 Fri
01/31/2212 Fri
07/31/2212 Fri
04/30/2213 Fri
12/31/2213 Fri
09/30/2214 Fri
03/31/2215 Fri
06/30/2215 Fri
05/31/2216 Fri
01/31/2217 Fri
02/28/2217 Fri
10/31/2217 Fri
07/31/2218 Fri
04/30/2219 Fri
12/31/2219 Fri
03/31/2220 Fri
06/30/2220 Fri
08/31/2221 Fri
11/30/2221 Fri
05/31/2222 Fri
01/31/2223 Fri
02/28/2223 Fri
10/31/2223 Fri
04/30/2224 Fri
12/31/2224 Fri
09/30/2225 Fri
03/31/2226 Fri
06/30/2226 Fri
08/31/2227 Fri
11/30/2227 Fri
02/29/2228 Fri
10/31/2228 Fri
07/31/2229 Fri
04/30/2230 Fri
12/31/2230 Fri
09/30/2231 Fri
08/31/2232 Fri
11/30/2232 Fri
05/31/2233 Fri
01/31/2234 Fri
02/28/2234 Fri
10/31/2234 Fri
07/31/2235 Fri
09/30/2236 Fri
03/31/2237 Fri
06/30/2237 Fri
08/31/2238 Fri
11/30/2238 Fri
05/31/2239 Fri
01/31/2240 Fri
07/31/2240 Fri
04/30/2241 Fri
12/31/2241 Fri
09/30/2242 Fri
03/31/2243 Fri
06/30/2243 Fri
05/31/2244 Fri
01/31/2245 Fri
02/28/2245 Fri
10/31/2245 Fri
07/31/2246 Fri
04/30/2247 Fri
12/31/2247 Fri
03/31/2248 Fri
06/30/2248 Fri
08/31/2249 Fri
11/30/2249 Fri
05/31/2250 Fri
01/31/2251 Fri
02/28/2251 Fri
10/31/2251 Fri
04/30/2252 Fri
12/31/2252 Fri
09/30/2253 Fri
03/31/2254 Fri
06/30/2254 Fri
08/31/2255 Fri
11/30/2255 Fri
02/29/2256 Fri
10/31/2256 Fri
07/31/2257 Fri
04/30/2258 Fri
12/31/2258 Fri
09/30/2259 Fri
08/31/2260 Fri
11/30/2260 Fri
05/31/2261 Fri
01/31/2262 Fri
02/28/2262 Fri
10/31/2262 Fri
07/31/2263 Fri
09/30/2264 Fri
03/31/2265 Fri
06/30/2265 Fri
08/31/2266 Fri
11/30/2266 Fri
05/31/2267 Fri
01/31/2268 Fri
07/31/2268 Fri
04/30/2269 Fri
12/31/2269 Fri
09/30/2270 Fri
03/31/2271 Fri
06/30/2271 Fri
05/31/2272 Fri
01/31/2273 Fri
02/28/2273 Fri
10/31/2273 Fri
07/31/2274 Fri
04/30/2275 Fri
12/31/2275 Fri
03/31/2276 Fri
06/30/2276 Fri
08/31/2277 Fri
11/30/2277 Fri
05/31/2278 Fri
01/31/2279 Fri
02/28/2279 Fri
10/31/2279 Fri
04/30/2280 Fri
12/31/2280 Fri
09/30/2281 Fri
03/31/2282 Fri
06/30/2282 Fri
08/31/2283 Fri
11/30/2283 Fri
02/29/2284 Fri
10/31/2284 Fri
07/31/2285 Fri
04/30/2286 Fri
12/31/2286 Fri
09/30/2287 Fri
08/31/2288 Fri
11/30/2288 Fri
05/31/2289 Fri
01/31/2290 Fri
02/28/2290 Fri
10/31/2290 Fri
07/31/2291 Fri
09/30/2292 Fri
03/31/2293 Fri
06/30/2293 Fri
08/31/2294 Fri
11/30/2294 Fri
05/31/2295 Fri
01/31/2296 Fri
07/31/2296 Fri
04/30/2297 Fri
12/31/2297 Fri
09/30/2298 Fri
03/31/2299 Fri
06/30/2299 Fri
08/31/2300 Fri
11/30/2300 Fri
05/31/2301 Fri
01/31/2302 Fri
02/28/2302 Fri
10/31/2302 Fri
07/31/2303 Fri
09/30/2304 Fri
03/31/2305 Fri
06/30/2305 Fri
08/31/2306 Fri
11/30/2306 Fri
05/31/2307 Fri
01/31/2308 Fri
07/31/2308 Fri
04/30/2309 Fri
12/31/2309 Fri
09/30/2310 Fri
03/31/2311 Fri
06/30/2311 Fri
05/31/2312 Fri
01/31/2313 Fri
02/28/2313 Fri
10/31/2313 Fri
07/31/2314 Fri
04/30/2315 Fri
12/31/2315 Fri
03/31/2316 Fri
06/30/2316 Fri
08/31/2317 Fri
11/30/2317 Fri
05/31/2318 Fri
01/31/2319 Fri
02/28/2319 Fri
10/31/2319 Fri
04/30/2320 Fri
12/31/2320 Fri
09/30/2321 Fri
03/31/2322 Fri
06/30/2322 Fri
08/31/2323 Fri
11/30/2323 Fri
02/29/2324 Fri
10/31/2324 Fri
07/31/2325 Fri
04/30/2326 Fri
12/31/2326 Fri
09/30/2327 Fri
08/31/2328 Fri
11/30/2328 Fri
05/31/2329 Fri
01/31/2330 Fri
02/28/2330 Fri
10/31/2330 Fri
07/31/2331 Fri
09/30/2332 Fri
03/31/2333 Fri
06/30/2333 Fri
08/31/2334 Fri
11/30/2334 Fri
05/31/2335 Fri
01/31/2336 Fri
07/31/2336 Fri
04/30/2337 Fri
12/31/2337 Fri
09/30/2338 Fri
03/31/2339 Fri
06/30/2339 Fri
05/31/2340 Fri
01/31/2341 Fri
02/28/2341 Fri
10/31/2341 Fri
07/31/2342 Fri
04/30/2343 Fri
12/31/2343 Fri
03/31/2344 Fri
06/30/2344 Fri
08/31/2345 Fri
11/30/2345 Fri
05/31/2346 Fri
01/31/2347 Fri
02/28/2347 Fri
10/31/2347 Fri
04/30/2348 Fri
12/31/2348 Fri
09/30/2349 Fri
03/31/2350 Fri
06/30/2350 Fri
08/31/2351 Fri
11/30/2351 Fri
02/29/2352 Fri
10/31/2352 Fri
07/31/2353 Fri
04/30/2354 Fri
12/31/2354 Fri
09/30/2355 Fri
08/31/2356 Fri
11/30/2356 Fri
05/31/2357 Fri
01/31/2358 Fri
02/28/2358 Fri
10/31/2358 Fri
07/31/2359 Fri
09/30/2360 Fri
03/31/2361 Fri
06/30/2361 Fri
08/31/2362 Fri
11/30/2362 Fri
05/31/2363 Fri
01/31/2364 Fri
07/31/2364 Fri
04/30/2365 Fri
12/31/2365 Fri
09/30/2366 Fri
03/31/2367 Fri
06/30/2367 Fri
05/31/2368 Fri
01/31/2369 Fri
02/28/2369 Fri
10/31/2369 Fri
07/31/2370 Fri
04/30/2371 Fri
12/31/2371 Fri
03/31/2372 Fri
06/30/2372 Fri
08/31/2373 Fri
11/30/2373 Fri
05/31/2374 Fri
01/31/2375 Fri
02/28/2375 Fri
10/31/2375 Fri
04/30/2376 Fri
12/31/2376 Fri
09/30/2377 Fri
03/31/2378 Fri
06/30/2378 Fri
08/31/2379 Fri
11/30/2379 Fri
02/29/2380 Fri
10/31/2380 Fri
07/31/2381 Fri
04/30/2382 Fri
12/31/2382 Fri
09/30/2383 Fri
08/31/2384 Fri
11/30/2384 Fri
05/31/2385 Fri
01/31/2386 Fri
02/28/2386 Fri
10/31/2386 Fri
07/31/2387 Fri
09/30/2388 Fri
03/31/2389 Fri
06/30/2389 Fri
08/31/2390 Fri
11/30/2390 Fri
05/31/2391 Fri
01/31/2392 Fri
07/31/2392 Fri
04/30/2393 Fri
12/31/2393 Fri
09/30/2394 Fri
03/31/2395 Fri
06/30/2395 Fri
05/31/2396 Fri
01/31/2397 Fri
02/28/2397 Fri
10/31/2397 Fri
07/31/2398 Fri
04/30/2399 Fri
12/31/2399 Fri
03/31/2400 Fri
06/30/2400 Fri
08/31/2401 Fri
11/30/2401 Fri
05/31/2402 Fri
01/31/2403 Fri
02/28/2403 Fri
10/31/2403 Fri
04/30/2404 Fri
12/31/2404 Fri
09/30/2405 Fri
03/31/2406 Fri
06/30/2406 Fri
08/31/2407 Fri
11/30/2407 Fri
02/29/2408 Fri
10/31/2408 Fri
07/31/2409 Fri
04/30/2410 Fri
12/31/2410 Fri
09/30/2411 Fri
08/31/2412 Fri
11/30/2412 Fri
05/31/2413 Fri
01/31/2414 Fri
02/28/2414 Fri
10/31/2414 Fri
07/31/2415 Fri
09/30/2416 Fri
03/31/2417 Fri
06/30/2417 Fri
08/31/2418 Fri
11/30/2418 Fri
05/31/2419 Fri
01/31/2420 Fri
07/31/2420 Fri
04/30/2421 Fri
12/31/2421 Fri
09/30/2422 Fri
03/31/2423 Fri
06/30/2423 Fri
05/31/2424 Fri
01/31/2425 Fri
02/28/2425 Fri
10/31/2425 Fri
07/31/2426 Fri
04/30/2427 Fri
12/31/2427 Fri
03/31/2428 Fri
06/30/2428 Fri
08/31/2429 Fri
11/30/2429 Fri
05/31/2430 Fri
01/31/2431 Fri
02/28/2431 Fri
10/31/2431 Fri
04/30/2432 Fri
12/31/2432 Fri
09/30/2433 Fri
03/31/2434 Fri
06/30/2434 Fri
08/31/2435 Fri
11/30/2435 Fri
02/29/2436 Fri
10/31/2436 Fri
07/31/2437 Fri
04/30/2438 Fri
12/31/2438 Fri
09/30/2439 Fri
08/31/2440 Fri
11/30/2440 Fri
05/31/2441 Fri
01/31/2442 Fri
02/28/2442 Fri
10/31/2442 Fri
07/31/2443 Fri
09/30/2444 Fri
03/31/2445 Fri
06/30/2445 Fri
08/31/2446 Fri
11/30/2446 Fri
05/31/2447 Fri
01/31/2448 Fri
07/31/2448 Fri
04/30/2449 Fri
12/31/2449 Fri
09/30/2450 Fri
03/31/2451 Fri
06/30/2451 Fri
05/31/2452 Fri
01/31/2453 Fri
02/28/2453 Fri
10/31/2453 Fri
07/31/2454 Fri
04/30/2455 Fri
12/31/2455 Fri
03/31/2456 Fri
06/30/2456 Fri
08/31/2457 Fri
11/30/2457 Fri
05/31/2458 Fri
01/31/2459 Fri
02/28/2459 Fri
10/31/2459 Fri
04/30/2460 Fri
12/31/2460 Fri
09/30/2461 Fri
03/31/2462 Fri
06/30/2462 Fri
08/31/2463 Fri
11/30/2463 Fri
02/29/2464 Fri
10/31/2464 Fri
07/31/2465 Fri
04/30/2466 Fri
12/31/2466 Fri
09/30/2467 Fri
08/31/2468 Fri
11/30/2468 Fri
05/31/2469 Fri
01/31/2470 Fri
02/28/2470 Fri
10/31/2470 Fri
07/31/2471 Fri
09/30/2472 Fri
03/31/2473 Fri
06/30/2473 Fri
08/31/2474 Fri
11/30/2474 Fri
05/31/2475 Fri
01/31/2476 Fri
07/31/2476 Fri
04/30/2477 Fri
12/31/2477 Fri
09/30/2478 Fri
03/31/2479 Fri
06/30/2479 Fri
05/31/2480 Fri
01/31/2481 Fri
02/28/2481 Fri
10/31/2481 Fri
07/31/2482 Fri
04/30/2483 Fri
12/31/2483 Fri
03/31/2484 Fri
06/30/2484 Fri
08/31/2485 Fri
11/30/2485 Fri
05/31/2486 Fri
01/31/2487 Fri
02/28/2487 Fri
10/31/2487 Fri
04/30/2488 Fri
12/31/2488 Fri
09/30/2489 Fri
03/31/2490 Fri
06/30/2490 Fri
08/31/2491 Fri
11/30/2491 Fri
02/29/2492 Fri
10/31/2492 Fri
07/31/2493 Fri
04/30/2494 Fri
12/31/2494 Fri
09/30/2495 Fri
08/31/2496 Fri
11/30/2496 Fri
05/31/2497 Fri
01/31/2498 Fri
02/28/2498 Fri
10/31/2498 Fri
07/31/2499 Fri
04/30/2500 Fri
12/31/2500 Fri
09/30/2501 Fri
03/31/2502 Fri
06/30/2502 Fri
08/31/2503 Fri
11/30/2503 Fri
02/29/2504 Fri
10/31/2504 Fri
07/31/2505 Fri
04/30/2506 Fri
12/31/2506 Fri
09/30/2507 Fri
08/31/2508 Fri
11/30/2508 Fri
05/31/2509 Fri
01/31/2510 Fri
02/28/2510 Fri
10/31/2510 Fri
07/31/2511 Fri
09/30/2512 Fri
03/31/2513 Fri
06/30/2513 Fri
08/31/2514 Fri
11/30/2514 Fri
05/31/2515 Fri
01/31/2516 Fri
07/31/2516 Fri
04/30/2517 Fri
12/31/2517 Fri
09/30/2518 Fri
03/31/2519 Fri
06/30/2519 Fri
05/31/2520 Fri
01/31/2521 Fri
02/28/2521 Fri
10/31/2521 Fri
07/31/2522 Fri
04/30/2523 Fri
12/31/2523 Fri
03/31/2524 Fri
06/30/2524 Fri
08/31/2525 Fri
11/30/2525 Fri
05/31/2526 Fri
01/31/2527 Fri
02/28/2527 Fri
10/31/2527 Fri
04/30/2528 Fri
12/31/2528 Fri
09/30/2529 Fri
03/31/2530 Fri
06/30/2530 Fri
08/31/2531 Fri
11/30/2531 Fri
02/29/2532 Fri
10/31/2532 Fri
07/31/2533 Fri
04/30/2534 Fri
12/31/2534 Fri
09/30/2535 Fri
08/31/2536 Fri
11/30/2536 Fri
05/31/2537 Fri
01/31/2538 Fri
02/28/2538 Fri
10/31/2538 Fri
07/31/2539 Fri
09/30/2540 Fri
03/31/2541 Fri
06/30/2541 Fri
08/31/2542 Fri
11/30/2542 Fri
05/31/2543 Fri
01/31/2544 Fri
07/31/2544 Fri
04/30/2545 Fri
12/31/2545 Fri
09/30/2546 Fri
03/31/2547 Fri
06/30/2547 Fri
05/31/2548 Fri
01/31/2549 Fri
02/28/2549 Fri
10/31/2549 Fri
07/31/2550 Fri
04/30/2551 Fri
12/31/2551 Fri
03/31/2552 Fri
06/30/2552 Fri
08/31/2553 Fri
11/30/2553 Fri
05/31/2554 Fri
01/31/2555 Fri
02/28/2555 Fri
10/31/2555 Fri
04/30/2556 Fri
12/31/2556 Fri
09/30/2557 Fri
03/31/2558 Fri
06/30/2558 Fri
08/31/2559 Fri
11/30/2559 Fri
02/29/2560 Fri
10/31/2560 Fri
07/31/2561 Fri
04/30/2562 Fri
12/31/2562 Fri
09/30/2563 Fri
08/31/2564 Fri
11/30/2564 Fri
05/31/2565 Fri
01/31/2566 Fri
02/28/2566 Fri
10/31/2566 Fri
07/31/2567 Fri
09/30/2568 Fri
03/31/2569 Fri
06/30/2569 Fri
08/31/2570 Fri
11/30/2570 Fri
05/31/2571 Fri
01/31/2572 Fri
07/31/2572 Fri
04/30/2573 Fri
12/31/2573 Fri
09/30/2574 Fri
03/31/2575 Fri
06/30/2575 Fri
05/31/2576 Fri
01/31/2577 Fri
02/28/2577 Fri
10/31/2577 Fri
07/31/2578 Fri
04/30/2579 Fri
12/31/2579 Fri
03/31/2580 Fri
06/30/2580 Fri
08/31/2581 Fri
11/30/2581 Fri
05/31/2582 Fri
01/31/2583 Fri
02/28/2583 Fri
10/31/2583 Fri
04/30/2584 Fri
12/31/2584 Fri
09/30/2585 Fri
03/31/2586 Fri
06/30/2586 Fri
08/31/2587 Fri
11/30/2587 Fri
02/29/2588 Fri
10/31/2588 Fri
07/31/2589 Fri
04/30/2590 Fri
12/31/2590 Fri
09/30/2591 Fri
08/31/2592 Fri
11/30/2592 Fri
05/31/2593 Fri
01/31/2594 Fri
02/28/2594 Fri
10/31/2594 Fri
07/31/2595 Fri
09/30/2596 Fri
03/31/2597 Fri
06/30/2597 Fri
08/31/2598 Fri
11/30/2598 Fri
05/31/2599 Fri
01/31/2600 Fri
02/28/2600 Fri
10/31/2600 Fri
07/31/2601 Fri
04/30/2602 Fri
12/31/2602 Fri
09/30/2603 Fri
08/31/2604 Fri
11/30/2604 Fri
05/31/2605 Fri
01/31/2606 Fri
02/28/2606 Fri
10/31/2606 Fri
07/31/2607 Fri
09/30/2608 Fri
03/31/2609 Fri
06/30/2609 Fri
08/31/2610 Fri
11/30/2610 Fri
05/31/2611 Fri
01/31/2612 Fri
07/31/2612 Fri
04/30/2613 Fri
12/31/2613 Fri
09/30/2614 Fri
03/31/2615 Fri
06/30/2615 Fri
05/31/2616 Fri
01/31/2617 Fri
02/28/2617 Fri
10/31/2617 Fri
07/31/2618 Fri
04/30/2619 Fri
12/31/2619 Fri
03/31/2620 Fri
06/30/2620 Fri
08/31/2621 Fri
11/30/2621 Fri
05/31/2622 Fri
01/31/2623 Fri
02/28/2623 Fri
10/31/2623 Fri
04/30/2624 Fri
12/31/2624 Fri
09/30/2625 Fri
03/31/2626 Fri
06/30/2626 Fri
08/31/2627 Fri
11/30/2627 Fri
02/29/2628 Fri
10/31/2628 Fri
07/31/2629 Fri
04/30/2630 Fri
12/31/2630 Fri
09/30/2631 Fri
08/31/2632 Fri
11/30/2632 Fri
05/31/2633 Fri
01/31/2634 Fri
02/28/2634 Fri
10/31/2634 Fri
07/31/2635 Fri
09/30/2636 Fri
03/31/2637 Fri
06/30/2637 Fri
08/31/2638 Fri
11/30/2638 Fri
05/31/2639 Fri
01/31/2640 Fri
07/31/2640 Fri
04/30/2641 Fri
12/31/2641 Fri
09/30/2642 Fri
03/31/2643 Fri
06/30/2643 Fri
05/31/2644 Fri
01/31/2645 Fri
02/28/2645 Fri
10/31/2645 Fri
07/31/2646 Fri
04/30/2647 Fri
12/31/2647 Fri
03/31/2648 Fri
06/30/2648 Fri
08/31/2649 Fri
11/30/2649 Fri
05/31/2650 Fri
01/31/2651 Fri
02/28/2651 Fri
10/31/2651 Fri
04/30/2652 Fri
12/31/2652 Fri
09/30/2653 Fri
03/31/2654 Fri
06/30/2654 Fri
08/31/2655 Fri
11/30/2655 Fri
02/29/2656 Fri
10/31/2656 Fri
07/31/2657 Fri
04/30/2658 Fri
12/31/2658 Fri
09/30/2659 Fri
08/31/2660 Fri
11/30/2660 Fri
05/31/2661 Fri
01/31/2662 Fri
02/28/2662 Fri
10/31/2662 Fri
07/31/2663 Fri
09/30/2664 Fri
03/31/2665 Fri
06/30/2665 Fri
08/31/2666 Fri
11/30/2666 Fri
05/31/2667 Fri
01/31/2668 Fri
07/31/2668 Fri
04/30/2669 Fri
12/31/2669 Fri
09/30/2670 Fri
03/31/2671 Fri
06/30/2671 Fri
05/31/2672 Fri
01/31/2673 Fri
02/28/2673 Fri
10/31/2673 Fri
07/31/2674 Fri
04/30/2675 Fri
12/31/2675 Fri
03/31/2676 Fri
06/30/2676 Fri
08/31/2677 Fri
11/30/2677 Fri
05/31/2678 Fri
01/31/2679 Fri
02/28/2679 Fri
10/31/2679 Fri
04/30/2680 Fri
12/31/2680 Fri
09/30/2681 Fri
03/31/2682 Fri
06/30/2682 Fri
08/31/2683 Fri
11/30/2683 Fri
02/29/2684 Fri
10/31/2684 Fri
07/31/2685 Fri
04/30/2686 Fri
12/31/2686 Fri
09/30/2687 Fri
08/31/2688 Fri
11/30/2688 Fri
05/31/2689 Fri
01/31/2690 Fri
02/28/2690 Fri
10/31/2690 Fri
07/31/2691 Fri
09/30/2692 Fri
03/31/2693 Fri
06/30/2693 Fri
08/31/2694 Fri
11/30/2694 Fri
05/31/2695 Fri
01/31/2696 Fri
07/31/2696 Fri
04/30/2697 Fri
12/31/2697 Fri
09/30/2698 Fri
03/31/2699 Fri
06/30/2699 Fri
08/31/2700 Fri
11/30/2700 Fri
05/31/2701 Fri
01/31/2702 Fri
02/28/2702 Fri
10/31/2702 Fri
07/31/2703 Fri
09/30/2704 Fri
03/31/2705 Fri
06/30/2705 Fri
08/31/2706 Fri
11/30/2706 Fri
05/31/2707 Fri
01/31/2708 Fri
07/31/2708 Fri
04/30/2709 Fri
12/31/2709 Fri
09/30/2710 Fri
03/31/2711 Fri
06/30/2711 Fri
05/31/2712 Fri
01/31/2713 Fri
02/28/2713 Fri
10/31/2713 Fri
07/31/2714 Fri
04/30/2715 Fri
12/31/2715 Fri
03/31/2716 Fri
06/30/2716 Fri
08/31/2717 Fri
11/30/2717 Fri
05/31/2718 Fri
01/31/2719 Fri
02/28/2719 Fri
10/31/2719 Fri
04/30/2720 Fri
12/31/2720 Fri
09/30/2721 Fri
03/31/2722 Fri
06/30/2722 Fri
08/31/2723 Fri
11/30/2723 Fri
02/29/2724 Fri
10/31/2724 Fri
07/31/2725 Fri
04/30/2726 Fri
12/31/2726 Fri
09/30/2727 Fri
08/31/2728 Fri
11/30/2728 Fri
05/31/2729 Fri
01/31/2730 Fri
02/28/2730 Fri
10/31/2730 Fri
07/31/2731 Fri
09/30/2732 Fri
03/31/2733 Fri
06/30/2733 Fri
08/31/2734 Fri
11/30/2734 Fri
05/31/2735 Fri
01/31/2736 Fri
07/31/2736 Fri
04/30/2737 Fri
12/31/2737 Fri
09/30/2738 Fri
03/31/2739 Fri
06/30/2739 Fri
05/31/2740 Fri
01/31/2741 Fri
02/28/2741 Fri
10/31/2741 Fri
07/31/2742 Fri
04/30/2743 Fri
12/31/2743 Fri
03/31/2744 Fri
06/30/2744 Fri
08/31/2745 Fri
11/30/2745 Fri
05/31/2746 Fri
01/31/2747 Fri
02/28/2747 Fri
10/31/2747 Fri
04/30/2748 Fri
12/31/2748 Fri
09/30/2749 Fri
03/31/2750 Fri
06/30/2750 Fri
08/31/2751 Fri
11/30/2751 Fri
02/29/2752 Fri
10/31/2752 Fri
07/31/2753 Fri
04/30/2754 Fri
12/31/2754 Fri
09/30/2755 Fri
08/31/2756 Fri
11/30/2756 Fri
05/31/2757 Fri
01/31/2758 Fri
02/28/2758 Fri
10/31/2758 Fri
07/31/2759 Fri
09/30/2760 Fri
03/31/2761 Fri
06/30/2761 Fri
08/31/2762 Fri
11/30/2762 Fri
05/31/2763 Fri
01/31/2764 Fri
07/31/2764 Fri
04/30/2765 Fri
12/31/2765 Fri
09/30/2766 Fri
03/31/2767 Fri
06/30/2767 Fri
05/31/2768 Fri
01/31/2769 Fri
02/28/2769 Fri
10/31/2769 Fri
07/31/2770 Fri
04/30/2771 Fri
12/31/2771 Fri
03/31/2772 Fri
06/30/2772 Fri
08/31/2773 Fri
11/30/2773 Fri
05/31/2774 Fri
01/31/2775 Fri
02/28/2775 Fri
10/31/2775 Fri
04/30/2776 Fri
12/31/2776 Fri
09/30/2777 Fri
03/31/2778 Fri
06/30/2778 Fri
08/31/2779 Fri
11/30/2779 Fri
02/29/2780 Fri
10/31/2780 Fri
07/31/2781 Fri
04/30/2782 Fri
12/31/2782 Fri
09/30/2783 Fri
08/31/2784 Fri
11/30/2784 Fri
05/31/2785 Fri
01/31/2786 Fri
02/28/2786 Fri
10/31/2786 Fri
07/31/2787 Fri
09/30/2788 Fri
03/31/2789 Fri
06/30/2789 Fri
08/31/2790 Fri
11/30/2790 Fri
05/31/2791 Fri
01/31/2792 Fri
07/31/2792 Fri
04/30/2793 Fri
12/31/2793 Fri
09/30/2794 Fri
03/31/2795 Fri
06/30/2795 Fri
05/31/2796 Fri
01/31/2797 Fri
02/28/2797 Fri
10/31/2797 Fri
07/31/2798 Fri
04/30/2799 Fri
12/31/2799 Fri
03/31/2800 Fri
06/30/2800 Fri
08/31/2801 Fri
11/30/2801 Fri
05/31/2802 Fri
01/31/2803 Fri
02/28/2803 Fri
10/31/2803 Fri
04/30/2804 Fri
12/31/2804 Fri
09/30/2805 Fri
03/31/2806 Fri
06/30/2806 Fri
08/31/2807 Fri
11/30/2807 Fri
02/29/2808 Fri
10/31/2808 Fri
07/31/2809 Fri
04/30/2810 Fri
12/31/2810 Fri
09/30/2811 Fri
08/31/2812 Fri
11/30/2812 Fri
05/31/2813 Fri
01/31/2814 Fri
02/28/2814 Fri
10/31/2814 Fri
07/31/2815 Fri
09/30/2816 Fri
03/31/2817 Fri
06/30/2817 Fri
08/31/2818 Fri
11/30/2818 Fri
05/31/2819 Fri
01/31/2820 Fri
07/31/2820 Fri
04/30/2821 Fri
12/31/2821 Fri
09/30/2822 Fri
03/31/2823 Fri
06/30/2823 Fri
05/31/2824 Fri
01/31/2825 Fri
02/28/2825 Fri
10/31/2825 Fri
07/31/2826 Fri
04/30/2827 Fri
12/31/2827 Fri
03/31/2828 Fri
06/30/2828 Fri
08/31/2829 Fri
11/30/2829 Fri
05/31/2830 Fri
01/31/2831 Fri
02/28/2831 Fri
10/31/2831 Fri
04/30/2832 Fri
12/31/2832 Fri
09/30/2833 Fri
03/31/2834 Fri
06/30/2834 Fri
08/31/2835 Fri
11/30/2835 Fri
02/29/2836 Fri
10/31/2836 Fri
07/31/2837 Fri
04/30/2838 Fri
12/31/2838 Fri
09/30/2839 Fri
08/31/2840 Fri
11/30/2840 Fri
05/31/2841 Fri
01/31/2842 Fri
02/28/2842 Fri
10/31/2842 Fri
07/31/2843 Fri
09/30/2844 Fri
03/31/2845 Fri
06/30/2845 Fri
08/31/2846 Fri
11/30/2846 Fri
05/31/2847 Fri
01/31/2848 Fri
07/31/2848 Fri
04/30/2849 Fri
12/31/2849 Fri
09/30/2850 Fri
03/31/2851 Fri
06/30/2851 Fri
05/31/2852 Fri
01/31/2853 Fri
02/28/2853 Fri
10/31/2853 Fri
07/31/2854 Fri
04/30/2855 Fri
12/31/2855 Fri
03/31/2856 Fri
06/30/2856 Fri
08/31/2857 Fri
11/30/2857 Fri
05/31/2858 Fri
01/31/2859 Fri
02/28/2859 Fri
10/31/2859 Fri
04/30/2860 Fri
12/31/2860 Fri
09/30/2861 Fri
03/31/2862 Fri
06/30/2862 Fri
08/31/2863 Fri
11/30/2863 Fri
02/29/2864 Fri
10/31/2864 Fri
07/31/2865 Fri
04/30/2866 Fri
12/31/2866 Fri
09/30/2867 Fri
08/31/2868 Fri
11/30/2868 Fri
05/31/2869 Fri
01/31/2870 Fri
02/28/2870 Fri
10/31/2870 Fri
07/31/2871 Fri
09/30/2872 Fri
03/31/2873 Fri
06/30/2873 Fri
08/31/2874 Fri
11/30/2874 Fri
05/31/2875 Fri
01/31/2876 Fri
07/31/2876 Fri
04/30/2877 Fri
12/31/2877 Fri
09/30/2878 Fri
03/31/2879 Fri
06/30/2879 Fri
05/31/2880 Fri
01/31/2881 Fri
02/28/2881 Fri
10/31/2881 Fri
07/31/2882 Fri
04/30/2883 Fri
12/31/2883 Fri
03/31/2884 Fri
06/30/2884 Fri
08/31/2885 Fri
11/30/2885 Fri
05/31/2886 Fri
01/31/2887 Fri
02/28/2887 Fri
10/31/2887 Fri
04/30/2888 Fri
12/31/2888 Fri
09/30/2889 Fri
03/31/2890 Fri
06/30/2890 Fri
08/31/2891 Fri
11/30/2891 Fri
02/29/2892 Fri
10/31/2892 Fri
07/31/2893 Fri
04/30/2894 Fri
12/31/2894 Fri
09/30/2895 Fri
08/31/2896 Fri
11/30/2896 Fri
05/31/2897 Fri
01/31/2898 Fri
02/28/2898 Fri
10/31/2898 Fri
07/31/2899 Fri
04/30/2900 Fri
12/31/2900 Fri
09/30/2901 Fri
03/31/2902 Fri
06/30/2902 Fri
08/31/2903 Fri
11/30/2903 Fri
02/29/2904 Fri
10/31/2904 Fri
07/31/2905 Fri
04/30/2906 Fri
12/31/2906 Fri
09/30/2907 Fri
08/31/2908 Fri
11/30/2908 Fri
05/31/2909 Fri
01/31/2910 Fri
02/28/2910 Fri
10/31/2910 Fri
07/31/2911 Fri
09/30/2912 Fri
03/31/2913 Fri
06/30/2913 Fri
08/31/2914 Fri
11/30/2914 Fri
05/31/2915 Fri
01/31/2916 Fri
07/31/2916 Fri
04/30/2917 Fri
12/31/2917 Fri
09/30/2918 Fri
03/31/2919 Fri
06/30/2919 Fri
05/31/2920 Fri
01/31/2921 Fri
02/28/2921 Fri
10/31/2921 Fri
07/31/2922 Fri
04/30/2923 Fri
12/31/2923 Fri
03/31/2924 Fri
06/30/2924 Fri
08/31/2925 Fri
11/30/2925 Fri
05/31/2926 Fri
01/31/2927 Fri
02/28/2927 Fri
10/31/2927 Fri
04/30/2928 Fri
12/31/2928 Fri
09/30/2929 Fri
03/31/2930 Fri
06/30/2930 Fri
08/31/2931 Fri
11/30/2931 Fri
02/29/2932 Fri
10/31/2932 Fri
07/31/2933 Fri
04/30/2934 Fri
12/31/2934 Fri
09/30/2935 Fri
08/31/2936 Fri
11/30/2936 Fri
05/31/2937 Fri
01/31/2938 Fri
02/28/2938 Fri
10/31/2938 Fri
07/31/2939 Fri
09/30/2940 Fri
03/31/2941 Fri
06/30/2941 Fri
08/31/2942 Fri
11/30/2942 Fri
05/31/2943 Fri
01/31/2944 Fri
07/31/2944 Fri
04/30/2945 Fri
12/31/2945 Fri
09/30/2946 Fri
03/31/2947 Fri
06/30/2947 Fri
05/31/2948 Fri
01/31/2949 Fri
02/28/2949 Fri
10/31/2949 Fri
07/31/2950 Fri
04/30/2951 Fri
12/31/2951 Fri
03/31/2952 Fri
06/30/2952 Fri
08/31/2953 Fri
11/30/2953 Fri
05/31/2954 Fri
01/31/2955 Fri
02/28/2955 Fri
10/31/2955 Fri
04/30/2956 Fri
12/31/2956 Fri
09/30/2957 Fri
03/31/2958 Fri
06/30/2958 Fri
08/31/2959 Fri
11/30/2959 Fri
02/29/2960 Fri
10/31/2960 Fri
07/31/2961 Fri
04/30/2962 Fri
12/31/2962 Fri
09/30/2963 Fri
08/31/2964 Fri
11/30/2964 Fri
05/31/2965 Fri
01/31/2966 Fri
02/28/2966 Fri
10/31/2966 Fri
07/31/2967 Fri
09/30/2968 Fri
03/31/2969 Fri
06/30/2969 Fri
08/31/2970 Fri
11/30/2970 Fri
05/31/2971 Fri
01/31/2972 Fri
07/31/2972 Fri
04/30/2973 Fri
12/31/2973 Fri
09/30/2974 Fri
03/31/2975 Fri
06/30/2975 Fri
05/31/2976 Fri
01/31/2977 Fri
02/28/2977 Fri
10/31/2977 Fri
07/31/2978 Fri
04/30/2979 Fri
12/31/2979 Fri
03/31/2980 Fri
06/30/2980 Fri
08/31/2981 Fri
11/30/2981 Fri
05/31/2982 Fri
01/31/2983 Fri
02/28/2983 Fri
10/31/2983 Fri
04/30/2984 Fri
12/31/2984 Fri
09/30/2985 Fri
03/31/2986 Fri
06/30/2986 Fri
08/31/2987 Fri
11/30/2987 Fri
02/29/2988 Fri
10/31/2988 Fri
07/31/2989 Fri
04/30/2990 Fri
12/31/2990 Fri
09/30/2991 Fri
08/31/2992 Fri
11/30/2992 Fri
05/31/2993 Fri
01/31/2994 Fri
02/28/2994 Fri
10/31/2994 Fri
07/31/2995 Fri
09/30/2996 Fri
03/31/2997 Fri
06/30/2997 Fri
08/31/2998 Fri
11/30/2998 Fri
05/31/2999 Fri
01/31/3000 Fri
02/28/3000 Fri
10/31/3000 Fri
count = 1764
*/