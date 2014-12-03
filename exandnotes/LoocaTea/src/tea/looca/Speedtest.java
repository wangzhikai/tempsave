package tea.looca;
import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Read the license following this comment before you do anything.
 * The only purpose of this file is for evaluation, criticism, bug-discovery and non-commerce.
 * 
 * @author Zhikai Wang
 * 
 * I improved the sample test mentioned below, by copying the text1 and text2 into an Intellij/Groovy file double quote pair ("").
 * It saves your trouble to find these files.
 * 
 * I don't claim any right upon this file.
 * You need two jars to add to your classpath or Eclipse project lib/build path etc.
 * ./diff_match_patch-current-src.jar
 * ./diff_match_patch-current.jar
 */
//Copyright 2010 Google Inc. All Rights Reserved.

/**
* Diff Speed Test
*
* Compile from google3/third_party/diff_match_patch/java with:
* javac name/fraser/neil/plaintext/Speedtest.java name/fraser/neil/plaintext/diff_match_patch.java
* Execute with:
* java name/fraser/neil/plaintext/Speedtest
*
* @author fraser@google.com (Neil Fraser)
*/
/*
 * Test harness for diff_match_patch.java
 *
 * Copyright 2006 Google Inc.
 * http://code.google.com/p/google-diff-match-patch/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class Speedtest {
	static final String text1 = "This is a '''list of newspapers published by [[Journal Register Company]]'''.\n" +
            "\n" +
            "The company owns daily and weekly newspapers, other print media properties and newspaper-affiliated local Websites in the [[U.S.]] states of [[Connecticut]], [[Michigan]], [[New York]], [[Ohio]] and [[Pennsylvania]], organized in six geographic \"clusters\":<ref>[http://www.journalregister.com/newspapers.html Journal Register Company: Our Newspapers], accessed February 10, 2008.</ref>\n" +
            "\n" +
            "== Capital-Saratoga ==\n" +
            "Three dailies, associated weeklies and [[pennysaver]]s in greater [[Albany, New York]]; also [http://www.capitalcentral.com capitalcentral.com] and [http://www.jobsinnewyork.com JobsInNewYork.com].\n" +
            "\n" +
            "* ''The Oneida Daily Dispatch'' {{WS|oneidadispatch.com}} of [[Oneida, New York]]\n" +
            "* ''[[The Record (Troy)|The Record]]'' {{WS|troyrecord.com}} of [[Troy, New York]]\n" +
            "* ''[[The Saratogian]]'' {{WS|saratogian.com}} of [[Saratoga Springs, New York]]\n" +
            "* Weeklies:\n" +
            "** ''Community News'' {{WS|cnweekly.com}} weekly of [[Clifton Park, New York]]\n" +
            "** ''Rome Observer'' of [[Rome, New York]]\n" +
            "** ''Life & Times of Utica'' of [[Utica, New York]]\n" +
            "\n" +
            "== Connecticut ==\n" +
            "Five dailies, associated weeklies and [[pennysaver]]s in the state of [[Connecticut]]; also [http://www.ctcentral.com CTcentral.com], [http://www.ctcarsandtrucks.com CTCarsAndTrucks.com] and [http://www.jobsinct.com JobsInCT.com].\n" +
            "\n" +
            "* ''The Middletown Press'' {{WS|middletownpress.com}} of [[Middletown, Connecticut|Middletown]]\n" +
            "* ''[[New Haven Register]]'' {{WS|newhavenregister.com}} of [[New Haven, Connecticut|New Haven]]\n" +
            "* ''The Register Citizen'' {{WS|registercitizen.com}} of [[Torrington, Connecticut|Torrington]]\n" +
            "\n" +
            "* [[New Haven Register#Competitors|Elm City Newspapers]] {{WS|ctcentral.com}}\n" +
            "** ''The Advertiser'' of [[East Haven, Connecticut|East Haven]]\n" +
            "** ''Hamden Chronicle'' of [[Hamden, Connecticut|Hamden]]\n" +
            "** ''Milford Weekly'' of [[Milford, Connecticut|Milford]]\n" +
            "** ''The Orange Bulletin'' of [[Orange, Connecticut|Orange]]\n" +
            "** ''The Post'' of [[North Haven, Connecticut|North Haven]]\n" +
            "** ''Shelton Weekly'' of [[Shelton, Connecticut|Shelton]]\n" +
            "** ''The Stratford Bard'' of [[Stratford, Connecticut|Stratford]]\n" +
            "** ''Wallingford Voice'' of [[Wallingford, Connecticut|Wallingford]]\n" +
            "** ''West Haven News'' of [[West Haven, Connecticut|West Haven]]\n" +
            "* Housatonic Publications \n" +
            "** ''The New Milford Times'' {{WS|newmilfordtimes.com}} of [[New Milford, Connecticut|New Milford]]\n" +
            "** ''The Brookfield Journal'' of [[Brookfield, Connecticut|Brookfield]]\n" +
            "** ''The Kent Good Times Dispatch'' of [[Kent, Connecticut|Kent]]\n" +
            "** ''The Bethel Beacon'' of [[Bethel, Connecticut|Bethel]]\n" +
            "** ''The Litchfield Enquirer'' of [[Litchfield, Connecticut|Litchfield]]\n" +
            "** ''Litchfield County Times'' of [[Litchfield, Connecticut|Litchfield]]\n" +
            "* Imprint Newspapers {{WS|imprintnewspapers.com}}\n" +
            "** ''West Hartford News'' of [[West Hartford, Connecticut|West Hartford]]\n" +
            "** ''Windsor Journal'' of [[Windsor, Connecticut|Windsor]]\n" +
            "** ''Windsor Locks Journal'' of [[Windsor Locks, Connecticut|Windsor Locks]]\n" +
            "** ''Avon Post'' of [[Avon, Connecticut|Avon]]\n" +
            "** ''Farmington Post'' of [[Farmington, Connecticut|Farmington]]\n" +
            "** ''Simsbury Post'' of [[Simsbury, Connecticut|Simsbury]]\n" +
            "** ''Tri-Town Post'' of [[Burlington, Connecticut|Burlington]], [[Canton, Connecticut|Canton]] and [[Harwinton, Connecticut|Harwinton]]\n" +
            "* Minuteman Publications\n" +
            "** ''[[Fairfield Minuteman]]'' of [[Fairfield, Connecticut|Fairfield]]\n" +
            "** ''The Westport Minuteman'' {{WS|westportminuteman.com}} of [[Westport, Connecticut|Westport]]\n" +
            "* Shoreline Newspapers weeklies:\n" +
            "** ''Branford Review'' of [[Branford, Connecticut|Branford]]\n" +
            "** ''Clinton Recorder'' of [[Clinton, Connecticut|Clinton]]\n" +
            "** ''The Dolphin'' of [[Naval Submarine Base New London]] in [[New London, Connecticut|New London]]\n" +
            "** ''Main Street News'' {{WS|ctmainstreetnews.com}} of [[Essex, Connecticut|Essex]]\n" +
            "** ''Pictorial Gazette'' of [[Old Saybrook, Connecticut|Old Saybrook]]\n" +
            "** ''Regional Express'' of [[Colchester, Connecticut|Colchester]]\n" +
            "** ''Regional Standard'' of [[Colchester, Connecticut|Colchester]]\n" +
            "** ''Shoreline Times'' {{WS|shorelinetimes.com}} of [[Guilford, Connecticut|Guilford]]\n" +
            "** ''Shore View East'' of [[Madison, Connecticut|Madison]]\n" +
            "** ''Shore View West'' of [[Guilford, Connecticut|Guilford]]\n" +
            "* Other weeklies:\n" +
            "** ''Registro'' {{WS|registroct.com}} of [[New Haven, Connecticut|New Haven]]\n" +
            "** ''Thomaston Express'' {{WS|thomastownexpress.com}} of [[Thomaston, Connecticut|Thomaston]]\n" +
            "** ''Foothills Traders'' {{WS|foothillstrader.com}} of Torrington, Bristol, Canton\n" +
            "\n" +
            "== Michigan ==\n" +
            "Four dailies, associated weeklies and [[pennysaver]]s in the state of [[Michigan]]; also [http://www.micentralhomes.com MIcentralhomes.com] and [http://www.micentralautos.com MIcentralautos.com]\n" +
            "* ''[[Oakland Press]]'' {{WS|theoaklandpress.com}} of [[Oakland, Michigan|Oakland]]\n" +
            "* ''Daily Tribune'' {{WS|dailytribune.com}} of [[Royal Oak, Michigan|Royal Oak]]\n" +
            "* ''Macomb Daily'' {{WS|macombdaily.com}} of [[Mt. Clemens, Michigan|Mt. Clemens]]\n" +
            "* ''[[Morning Sun]]'' {{WS|themorningsun.com}} of  [[Mount Pleasant, Michigan|Mount Pleasant]]\n" +
            "* Heritage Newspapers {{WS|heritage.com}}\n" +
            "** ''Belleville View''\n" +
            "** ''Ile Camera''\n" +
            "** ''Monroe Guardian''\n" +
            "** ''Ypsilanti Courier''\n" +
            "** ''News-Herald''\n" +
            "** ''Press & Guide''\n" +
            "** ''Chelsea Standard & Dexter Leader''\n" +
            "** ''Manchester Enterprise''\n" +
            "** ''Milan News-Leader''\n" +
            "** ''Saline Reporter''\n" +
            "* Independent Newspapers {{WS|sourcenewspapers.com}}\n" +
            "** ''Advisor''\n" +
            "** ''Source''\n" +
            "* Morning Star {{WS|morningstarpublishing.com}}\n" +
            "** ''Alma Reminder''\n" +
            "** ''Alpena Star''\n" +
            "** ''Antrim County News''\n" +
            "** ''Carson City Reminder''\n" +
            "** ''The Leader & Kalkaskian''\n" +
            "** ''Ogemaw/Oscoda County Star''\n" +
            "** ''Petoskey/Charlevoix Star''\n" +
            "** ''Presque Isle Star''\n" +
            "** ''Preview Community Weekly''\n" +
            "** ''Roscommon County Star''\n" +
            "** ''St. Johns Reminder''\n" +
            "** ''Straits Area Star''\n" +
            "** ''The (Edmore) Advertiser'' \n" +
            "* Voice Newspapers {{WS|voicenews.com}}\n" +
            "** ''Armada Times''\n" +
            "** ''Bay Voice''\n" +
            "** ''Blue Water Voice''\n" +
            "** ''Downriver Voice''\n" +
            "** ''Macomb Township Voice''\n" +
            "** ''North Macomb Voice''\n" +
            "** ''Weekend Voice''\n" +
            "** ''Suburban Lifestyles'' {{WS|suburbanlifestyles.com}}\n" +
            "\n" +
            "== Mid-Hudson ==\n" +
            "One daily, associated magazines in the [[Hudson River Valley]] of [[New York]]; also [http://www.midhudsoncentral.com MidHudsonCentral.com] and [http://www.jobsinnewyork.com JobsInNewYork.com].\n" +
            "\n" +
            "* ''[[Daily Freeman]]'' {{WS|dailyfreeman.com}} of [[Kingston, New York]]\n" +
            "\n" +
            "== Ohio ==\n" +
            "Two dailies, associated magazines and three shared Websites, all in the state of [[Ohio]]: [http://www.allaroundcleveland.com AllAroundCleveland.com], [http://www.allaroundclevelandcars.com AllAroundClevelandCars.com] and [http://www.allaroundclevelandjobs.com AllAroundClevelandJobs.com].\n" +
            "\n" +
            "* ''[[The News-Herald (Ohio)|The News-Herald]]'' {{WS|news-herald.com}} of [[Willoughby, Ohio|Willoughby]]\n" +
            "* ''[[The Morning Journal]]'' {{WS|morningjournal.com}} of [[Lorain, Ohio|Lorain]]\n" +
            "\n" +
            "== Philadelphia area ==\n" +
            "Seven dailies and associated weeklies and magazines in [[Pennsylvania]] and [[New Jersey]], and associated Websites: [http://www.allaroundphilly.com AllAroundPhilly.com], [http://www.jobsinnj.com JobsInNJ.com], [http://www.jobsinpa.com JobsInPA.com], and [http://www.phillycarsearch.com PhillyCarSearch.com].\n" +
            "\n" +
            "* ''The Daily Local'' {{WS|dailylocal.com}} of [[West Chester, Pennsylvania|West Chester]]\n" +
            "* ''[[Delaware County Daily and Sunday Times]] {{WS|delcotimes.com}} of Primos\n" +
            "* ''[[The Mercury (Pennsylvania)|The Mercury]]'' {{WS|pottstownmercury.com}} of [[Pottstown, Pennsylvania|Pottstown]]\n" +
            "* ''The Phoenix'' {{WS|phoenixvillenews.com}} of [[Phoenixville, Pennsylvania|Phoenixville]]\n" +
            "* ''[[The Reporter (Lansdale)|The Reporter]]'' {{WS|thereporteronline.com}} of [[Lansdale, Pennsylvania|Lansdale]]\n" +
            "* ''The Times Herald'' {{WS|timesherald.com}} of [[Norristown, Pennsylvania|Norristown]]\n" +
            "* ''[[The Trentonian]]'' {{WS|trentonian.com}} of [[Trenton, New Jersey]]\n" +
            "\n" +
            "* Weeklies\n" +
            "** ''El Latino Expreso'' of [[Trenton, New Jersey]]\n" +
            "** ''La Voz'' of [[Norristown, Pennsylvania]]\n" +
            "** ''The Village News'' of [[Downingtown, Pennsylvania]]\n" +
            "** ''The Times Record'' of [[Kennett Square, Pennsylvania]]\n" +
            "** ''The Tri-County Record'' {{WS|tricountyrecord.com}} of [[Morgantown, Pennsylvania]]\n" +
            "** ''News of Delaware County'' {{WS|newsofdelawarecounty.com}}of [[Havertown, Pennsylvania]]\n" +
            "** ''Main Line Times'' {{WS|mainlinetimes.com}}of [[Ardmore, Pennsylvania]]\n" +
            "** ''Penny Pincher'' of [[Pottstown, Pennsylvania]]\n" +
            "** ''Town Talk'' {{WS|towntalknews.com}} of [[Ridley, Pennsylvania]]\n" +
            "* Chesapeake Publishing {{WS|pa8newsgroup.com}} \n" +
            "** ''Solanco Sun Ledger'' of [[Quarryville, Pennsylvania]]\n" +
            "** ''Columbia Ledger'' of [[Columbia, Pennsylvania]]\n" +
            "** ''Coatesville Ledger'' of [[Downingtown, Pennsylvania]]\n" +
            "** ''Parkesburg Post Ledger'' of [[Quarryville, Pennsylvania]]\n" +
            "** ''Downingtown Ledger'' of [[Downingtown, Pennsylvania]]\n" +
            "** ''The Kennett Paper'' of [[Kennett Square, Pennsylvania]]\n" +
            "** ''Avon Grove Sun'' of [[West Grove, Pennsylvania]]\n" +
            "** ''Oxford Tribune'' of [[Oxford, Pennsylvania]]\n" +
            "** ''Elizabethtown Chronicle'' of [[Elizabethtown, Pennsylvania]]\n" +
            "** ''Donegal Ledger'' of [[Donegal, Pennsylvania]]\n" +
            "** ''Chadds Ford Post'' of [[Chadds Ford, Pennsylvania]]\n" +
            "** ''The Central Record'' of [[Medford, New Jersey]]\n" +
            "** ''Maple Shade Progress'' of [[Maple Shade, New Jersey]]\n" +
            "* Intercounty Newspapers {{WS|buckslocalnews.com}} \n" +
            "** ''The Review'' of Roxborough, Pennsylvania\n" +
            "** ''The Recorder'' of [[Conshohocken, Pennsylvania]]\n" +
            "** ''The Leader'' of [[Mount Airy, Pennsylvania|Mount Airy]] and West Oak Lake, Pennsylvania\n" +
            "** ''The Pennington Post'' of [[Pennington, New Jersey]]\n" +
            "** ''The Bristol Pilot'' of [[Bristol, Pennsylvania]]\n" +
            "** ''Yardley News'' of [[Yardley, Pennsylvania]]\n" +
            "** ''New Hope Gazette'' of [[New Hope, Pennsylvania]]\n" +
            "** ''Doylestown Patriot'' of [[Doylestown, Pennsylvania]]\n" +
            "** ''Newtown Advance'' of [[Newtown, Pennsylvania]]\n" +
            "** ''The Plain Dealer'' of [[Williamstown, New Jersey]]\n" +
            "** ''News Report'' of [[Sewell, New Jersey]]\n" +
            "** ''Record Breeze'' of [[Berlin, New Jersey]]\n" +
            "** ''Newsweekly'' of [[Moorestown, New Jersey]]\n" +
            "** ''Haddon Herald'' of [[Haddonfield, New Jersey]]\n" +
            "** ''New Egypt Press'' of [[New Egypt, New Jersey]]\n" +
            "** ''Community News'' of [[Pemberton, New Jersey]]\n" +
            "** ''Plymouth Meeting Journal'' of [[Plymouth Meeting, Pennsylvania]]\n" +
            "** ''Lafayette Hill Journal'' of [[Lafayette Hill, Pennsylvania]]\n" +
            "* Montgomery Newspapers {{WS|montgomerynews.com}} \n" +
            "** ''Ambler Gazette'' of [[Ambler, Pennsylvania]]\n" +
            "** ''Central Bucks Life'' of [[Bucks County, Pennsylvania]]\n" +
            "** ''The Colonial'' of [[Plymouth Meeting, Pennsylvania]]\n" +
            "** ''Glenside News'' of [[Glenside, Pennsylvania]]\n" +
            "** ''The Globe'' of [[Lower Moreland Township, Pennsylvania]]\n" +
            "** ''Main Line Life'' of [[Ardmore, Pennsylvania]]\n" +
            "** ''Montgomery Life'' of [[Fort Washington, Pennsylvania]]\n" +
            "** ''North Penn Life'' of [[Lansdale, Pennsylvania]]\n" +
            "** ''Perkasie News Herald'' of [[Perkasie, Pennsylvania]]\n" +
            "** ''Public Spirit'' of [[Hatboro, Pennsylvania]]\n" +
            "** ''Souderton Independent'' of [[Souderton, Pennsylvania]]\n" +
            "** ''Springfield Sun'' of [[Springfield, Pennsylvania]]\n" +
            "** ''Spring-Ford Reporter'' of [[Royersford, Pennsylvania]]\n" +
            "** ''Times Chronicle'' of [[Jenkintown, Pennsylvania]]\n" +
            "** ''Valley Item'' of [[Perkiomenville, Pennsylvania]]\n" +
            "** ''Willow Grove Guide'' of [[Willow Grove, Pennsylvania]]\n" +
            "* News Gleaner Publications (closed December 2008) {{WS|newsgleaner.com}} \n" +
            "** ''Life Newspapers'' of [[Philadelphia, Pennsylvania]]\n" +
            "* Suburban Publications\n" +
            "** ''The Suburban & Wayne Times'' {{WS|waynesuburban.com}} of [[Wayne, Pennsylvania]]\n" +
            "** ''The Suburban Advertiser'' of [[Exton, Pennsylvania]]\n" +
            "** ''The King of Prussia Courier'' of [[King of Prussia, Pennsylvania]]\n" +
            "* Press Newspapers {{WS|countypressonline.com}} \n" +
            "** ''County Press'' of [[Newtown Square, Pennsylvania]]\n" +
            "** ''Garnet Valley Press'' of [[Glen Mills, Pennsylvania]]\n" +
            "** ''Haverford Press'' of [[Newtown Square, Pennsylvania]] (closed January 2009)\n" +
            "** ''Hometown Press'' of [[Glen Mills, Pennsylvania]] (closed January 2009)\n" +
            "** ''Media Press'' of [[Newtown Square, Pennsylvania]] (closed January 2009)\n" +
            "** ''Springfield Press'' of [[Springfield, Pennsylvania]]\n" +
            "* Berks-Mont Newspapers {{WS|berksmontnews.com}} \n" +
            "** ''The Boyertown Area Times'' of [[Boyertown, Pennsylvania]]\n" +
            "** ''The Kutztown Area Patriot'' of [[Kutztown, Pennsylvania]]\n" +
            "** ''The Hamburg Area Item'' of [[Hamburg, Pennsylvania]]\n" +
            "** ''The Southern Berks News'' of [[Exeter Township, Berks County, Pennsylvania]]\n" +
            "** ''The Free Press'' of [[Quakertown, Pennsylvania]]\n" +
            "** ''The Saucon News'' of [[Quakertown, Pennsylvania]]\n" +
            "** ''Westside Weekly'' of [[Reading, Pennsylvania]]\n" +
            "\n" +
            "* Magazines\n" +
            "** ''Bucks Co. Town & Country Living''\n" +
            "** ''Chester Co. Town & Country Living''\n" +
            "** ''Montomgery Co. Town & Country Living''\n" +
            "** ''Garden State Town & Country Living''\n" +
            "** ''Montgomery Homes''\n" +
            "** ''Philadelphia Golfer''\n" +
            "** ''Parents Express''\n" +
            "** ''Art Matters''\n" +
            "\n" +
            "{{JRC}}\n" +
            "\n" +
            "==References==\n" +
            "<references />\n" +
            "\n" +
            "[[Category:Journal Register publications|*]]";
	static final String text2 = "This is a '''list of newspapers published by [[Journal Register Company]]'''.\n" +
            "\n" +
            "The company owns daily and weekly newspapers, other print media properties and newspaper-affiliated local Websites in the [[U.S.]] states of [[Connecticut]], [[Michigan]], [[New York]], [[Ohio]], [[Pennsylvania]] and [[New Jersey]], organized in six geographic \"clusters\":<ref>[http://www.journalregister.com/publications.html Journal Register Company: Our Publications], accessed April 21, 2010.</ref>\n" +
            "\n" +
            "== Capital-Saratoga ==\n" +
            "Three dailies, associated weeklies and [[pennysaver]]s in greater [[Albany, New York]]; also [http://www.capitalcentral.com capitalcentral.com] and [http://www.jobsinnewyork.com JobsInNewYork.com].\n" +
            "\n" +
            "* ''The Oneida Daily Dispatch'' {{WS|oneidadispatch.com}} of [[Oneida, New York]]\n" +
            "* ''[[The Record (Troy)|The Record]]'' {{WS|troyrecord.com}} of [[Troy, New York]]\n" +
            "* ''[[The Saratogian]]'' {{WS|saratogian.com}} of [[Saratoga Springs, New York]]\n" +
            "* Weeklies:\n" +
            "** ''Community News'' {{WS|cnweekly.com}} weekly of [[Clifton Park, New York]]\n" +
            "** ''Rome Observer'' {{WS|romeobserver.com}} of [[Rome, New York]]\n" +
            "** ''WG Life '' {{WS|saratogian.com/wglife/}} of [[Wilton, New York]]\n" +
            "** ''Ballston Spa Life '' {{WS|saratogian.com/bspalife}} of [[Ballston Spa, New York]]\n" +
            "** ''Greenbush Life'' {{WS|troyrecord.com/greenbush}} of [[Troy, New York]]\n" +
            "** ''Latham Life'' {{WS|troyrecord.com/latham}} of [[Latham, New York]]\n" +
            "** ''River Life'' {{WS|troyrecord.com/river}} of [[Troy, New York]]\n" +
            "\n" +
            "== Connecticut ==\n" +
            "Three dailies, associated weeklies and [[pennysaver]]s in the state of [[Connecticut]]; also [http://www.ctcentral.com CTcentral.com], [http://www.ctcarsandtrucks.com CTCarsAndTrucks.com] and [http://www.jobsinct.com JobsInCT.com].\n" +
            "\n" +
            "* ''The Middletown Press'' {{WS|middletownpress.com}} of [[Middletown, Connecticut|Middletown]]\n" +
            "* ''[[New Haven Register]]'' {{WS|newhavenregister.com}} of [[New Haven, Connecticut|New Haven]]\n" +
            "* ''The Register Citizen'' {{WS|registercitizen.com}} of [[Torrington, Connecticut|Torrington]]\n" +
            "\n" +
            "* Housatonic Publications \n" +
            "** ''The Housatonic Times'' {{WS|housatonictimes.com}} of [[New Milford, Connecticut|New Milford]]\n" +
            "** ''Litchfield County Times'' {{WS|countytimes.com}} of [[Litchfield, Connecticut|Litchfield]]\n" +
            "\n" +
            "* Minuteman Publications\n" +
            "** ''[[Fairfield Minuteman]]'' {{WS|fairfieldminuteman.com}}of [[Fairfield, Connecticut|Fairfield]]\n" +
            "** ''The Westport Minuteman'' {{WS|westportminuteman.com}} of [[Westport, Connecticut|Westport]]\n" +
            "\n" +
            "* Shoreline Newspapers \n" +
            "** ''The Dolphin'' {{WS|dolphin-news.com}} of [[Naval Submarine Base New London]] in [[New London, Connecticut|New London]]\n" +
            "** ''Shoreline Times'' {{WS|shorelinetimes.com}} of [[Guilford, Connecticut|Guilford]]\n" +
            "\n" +
            "* Foothills Media Group {{WS|foothillsmediagroup.com}}\n" +
            "** ''Thomaston Express'' {{WS|thomastonexpress.com}} of [[Thomaston, Connecticut|Thomaston]]\n" +
            "** ''Good News About Torrington'' {{WS|goodnewsabouttorrington.com}} of [[Torrington, Connecticut|Torrington]]\n" +
            "** ''Granby News'' {{WS|foothillsmediagroup.com/granby}} of [[Granby, Connecticut|Granby]]\n" +
            "** ''Canton News'' {{WS|foothillsmediagroup.com/canton}} of [[Canton, Connecticut|Canton]]\n" +
            "** ''Avon News'' {{WS|foothillsmediagroup.com/avon}} of [[Avon, Connecticut|Avon]]\n" +
            "** ''Simsbury News'' {{WS|foothillsmediagroup.com/simsbury}} of [[Simsbury, Connecticut|Simsbury]]\n" +
            "** ''Litchfield News'' {{WS|foothillsmediagroup.com/litchfield}} of [[Litchfield, Connecticut|Litchfield]]\n" +
            "** ''Foothills Trader'' {{WS|foothillstrader.com}} of Torrington, Bristol, Canton\n" +
            "\n" +
            "* Other weeklies\n" +
            "** ''The Milford-Orange Bulletin'' {{WS|ctbulletin.com}} of [[Orange, Connecticut|Orange]]\n" +
            "** ''The Post-Chronicle'' {{WS|ctpostchronicle.com}} of [[North Haven, Connecticut|North Haven]]\n" +
            "** ''West Hartford News'' {{WS|westhartfordnews.com}} of [[West Hartford, Connecticut|West Hartford]]\n" +
            "\n" +
            "* Magazines\n" +
            "** ''The Connecticut Bride'' {{WS|connecticutmag.com}}\n" +
            "** ''Connecticut Magazine'' {{WS|theconnecticutbride.com}}\n" +
            "** ''Passport Magazine'' {{WS|passport-mag.com}}\n" +
            "\n" +
            "== Michigan ==\n" +
            "Four dailies, associated weeklies and [[pennysaver]]s in the state of [[Michigan]]; also [http://www.micentralhomes.com MIcentralhomes.com] and [http://www.micentralautos.com MIcentralautos.com]\n" +
            "* ''[[Oakland Press]]'' {{WS|theoaklandpress.com}} of [[Oakland, Michigan|Oakland]]\n" +
            "* ''Daily Tribune'' {{WS|dailytribune.com}} of [[Royal Oak, Michigan|Royal Oak]]\n" +
            "* ''Macomb Daily'' {{WS|macombdaily.com}} of [[Mt. Clemens, Michigan|Mt. Clemens]]\n" +
            "* ''[[Morning Sun]]'' {{WS|themorningsun.com}} of  [[Mount Pleasant, Michigan|Mount Pleasant]]\n" +
            "\n" +
            "* Heritage Newspapers {{WS|heritage.com}}\n" +
            "** ''Belleville View'' {{WS|bellevilleview.com}}\n" +
            "** ''Ile Camera'' {{WS|thenewsherald.com/ile_camera}}\n" +
            "** ''Monroe Guardian''  {{WS|monreguardian.com}}\n" +
            "** ''Ypsilanti Courier'' {{WS|ypsilanticourier.com}}\n" +
            "** ''News-Herald'' {{WS|thenewsherald.com}}\n" +
            "** ''Press & Guide'' {{WS|pressandguide.com}}\n" +
            "** ''Chelsea Standard & Dexter Leader'' {{WS|chelseastandard.com}}\n" +
            "** ''Manchester Enterprise'' {{WS|manchesterguardian.com}}\n" +
            "** ''Milan News-Leader'' {{WS|milannews.com}}\n" +
            "** ''Saline Reporter'' {{WS|salinereporter.com}}\n" +
            "* Independent Newspapers \n" +
            "** ''Advisor'' {{WS|sourcenewspapers.com}}\n" +
            "** ''Source'' {{WS|sourcenewspapers.com}}\n" +
            "* Morning Star {{WS|morningstarpublishing.com}}\n" +
            "** ''The Leader & Kalkaskian'' {{WS|leaderandkalkaskian.com}}\n" +
            "** ''Grand Traverse Insider'' {{WS|grandtraverseinsider.com}}\n" +
            "** ''Alma Reminder''\n" +
            "** ''Alpena Star''\n" +
            "** ''Ogemaw/Oscoda County Star''\n" +
            "** ''Presque Isle Star''\n" +
            "** ''St. Johns Reminder''\n" +
            "\n" +
            "* Voice Newspapers {{WS|voicenews.com}}\n" +
            "** ''Armada Times''\n" +
            "** ''Bay Voice''\n" +
            "** ''Blue Water Voice''\n" +
            "** ''Downriver Voice''\n" +
            "** ''Macomb Township Voice''\n" +
            "** ''North Macomb Voice''\n" +
            "** ''Weekend Voice''\n" +
            "\n" +
            "== Mid-Hudson ==\n" +
            "One daily, associated magazines in the [[Hudson River Valley]] of [[New York]]; also [http://www.midhudsoncentral.com MidHudsonCentral.com] and [http://www.jobsinnewyork.com JobsInNewYork.com].\n" +
            "\n" +
            "* ''[[Daily Freeman]]'' {{WS|dailyfreeman.com}} of [[Kingston, New York]]\n" +
            "* ''Las Noticias'' {{WS|lasnoticiasny.com}} of [[Kingston, New York]]\n" +
            "\n" +
            "== Ohio ==\n" +
            "Two dailies, associated magazines and three shared Websites, all in the state of [[Ohio]]: [http://www.allaroundcleveland.com AllAroundCleveland.com], [http://www.allaroundclevelandcars.com AllAroundClevelandCars.com] and [http://www.allaroundclevelandjobs.com AllAroundClevelandJobs.com].\n" +
            "\n" +
            "* ''[[The News-Herald (Ohio)|The News-Herald]]'' {{WS|news-herald.com}} of [[Willoughby, Ohio|Willoughby]]\n" +
            "* ''[[The Morning Journal]]'' {{WS|morningjournal.com}} of [[Lorain, Ohio|Lorain]]\n" +
            "* ''El Latino Expreso'' {{WS|lorainlatino.com}} of [[Lorain, Ohio|Lorain]]\n" +
            "\n" +
            "== Philadelphia area ==\n" +
            "Seven dailies and associated weeklies and magazines in [[Pennsylvania]] and [[New Jersey]], and associated Websites: [http://www.allaroundphilly.com AllAroundPhilly.com], [http://www.jobsinnj.com JobsInNJ.com], [http://www.jobsinpa.com JobsInPA.com], and [http://www.phillycarsearch.com PhillyCarSearch.com].\n" +
            "\n" +
            "* ''[[The Daily Local News]]'' {{WS|dailylocal.com}} of [[West Chester, Pennsylvania|West Chester]]\n" +
            "* ''[[Delaware County Daily and Sunday Times]] {{WS|delcotimes.com}} of Primos [[Upper Darby Township, Pennsylvania]]\n" +
            "* ''[[The Mercury (Pennsylvania)|The Mercury]]'' {{WS|pottstownmercury.com}} of [[Pottstown, Pennsylvania|Pottstown]]\n" +
            "* ''[[The Reporter (Lansdale)|The Reporter]]'' {{WS|thereporteronline.com}} of [[Lansdale, Pennsylvania|Lansdale]]\n" +
            "* ''The Times Herald'' {{WS|timesherald.com}} of [[Norristown, Pennsylvania|Norristown]]\n" +
            "* ''[[The Trentonian]]'' {{WS|trentonian.com}} of [[Trenton, New Jersey]]\n" +
            "\n" +
            "* Weeklies\n" +
            "* ''The Phoenix'' {{WS|phoenixvillenews.com}} of [[Phoenixville, Pennsylvania]]\n" +
            "** ''El Latino Expreso'' {{WS|njexpreso.com}} of [[Trenton, New Jersey]]\n" +
            "** ''La Voz'' {{WS|lavozpa.com}} of [[Norristown, Pennsylvania]]\n" +
            "** ''The Tri County Record'' {{WS|tricountyrecord.com}} of [[Morgantown, Pennsylvania]]\n" +
            "** ''Penny Pincher'' {{WS|pennypincherpa.com}}of [[Pottstown, Pennsylvania]]\n" +
            "\n" +
            "* Chesapeake Publishing  {{WS|southernchestercountyweeklies.com}}\n" +
            "** ''The Kennett Paper'' {{WS|kennettpaper.com}} of [[Kennett Square, Pennsylvania]]\n" +
            "** ''Avon Grove Sun'' {{WS|avongrovesun.com}} of [[West Grove, Pennsylvania]]\n" +
            "** ''The Central Record'' {{WS|medfordcentralrecord.com}} of [[Medford, New Jersey]]\n" +
            "** ''Maple Shade Progress'' {{WS|mapleshadeprogress.com}} of [[Maple Shade, New Jersey]]\n" +
            "\n" +
            "* Intercounty Newspapers {{WS|buckslocalnews.com}} {{WS|southjerseylocalnews.com}} \n" +
            "** ''The Pennington Post'' {{WS|penningtonpost.com}} of [[Pennington, New Jersey]]\n" +
            "** ''The Bristol Pilot'' {{WS|bristolpilot.com}} of [[Bristol, Pennsylvania]]\n" +
            "** ''Yardley News'' {{WS|yardleynews.com}} of [[Yardley, Pennsylvania]]\n" +
            "** ''Advance of Bucks County'' {{WS|advanceofbucks.com}} of [[Newtown, Pennsylvania]]\n" +
            "** ''Record Breeze'' {{WS|recordbreeze.com}} of [[Berlin, New Jersey]]\n" +
            "** ''Community News'' {{WS|sjcommunitynews.com}} of [[Pemberton, New Jersey]]\n" +
            "\n" +
            "* Montgomery Newspapers {{WS|montgomerynews.com}} \n" +
            "** ''Ambler Gazette'' {{WS|amblergazette.com}} of [[Ambler, Pennsylvania]]\n" +
            "** ''The Colonial'' {{WS|colonialnews.com}} of [[Plymouth Meeting, Pennsylvania]]\n" +
            "** ''Glenside News'' {{WS|glensidenews.com}} of [[Glenside, Pennsylvania]]\n" +
            "** ''The Globe'' {{WS|globenewspaper.com}} of [[Lower Moreland Township, Pennsylvania]]\n" +
            "** ''Montgomery Life'' {{WS|montgomerylife.com}} of [[Fort Washington, Pennsylvania]]\n" +
            "** ''North Penn Life'' {{WS|northpennlife.com}} of [[Lansdale, Pennsylvania]]\n" +
            "** ''Perkasie News Herald'' {{WS|perkasienewsherald.com}} of [[Perkasie, Pennsylvania]]\n" +
            "** ''Public Spirit'' {{WS|thepublicspirit.com}} of [[Hatboro, Pennsylvania]]\n" +
            "** ''Souderton Independent'' {{WS|soudertonindependent.com}} of [[Souderton, Pennsylvania]]\n" +
            "** ''Springfield Sun'' {{WS|springfieldsun.com}} of [[Springfield, Pennsylvania]]\n" +
            "** ''Spring-Ford Reporter'' {{WS|springfordreporter.com}} of [[Royersford, Pennsylvania]]\n" +
            "** ''Times Chronicle'' {{WS|thetimeschronicle.com}} of [[Jenkintown, Pennsylvania]]\n" +
            "** ''Valley Item'' {{WS|valleyitem.com}} of [[Perkiomenville, Pennsylvania]]\n" +
            "** ''Willow Grove Guide'' {{WS|willowgroveguide.com}} of [[Willow Grove, Pennsylvania]]\n" +
            "** ''The Review'' {{WS|roxreview.com}} of [[Roxborough, Philadelphia, Pennsylvania]]\n" +
            "\n" +
            "* Main Line Media News {{WS|mainlinemedianews.com}}\n" +
            "** ''Main Line Times'' {{WS|mainlinetimes.com}} of [[Ardmore, Pennsylvania]]\n" +
            "** ''Main Line Life'' {{WS|mainlinelife.com}} of [[Ardmore, Pennsylvania]]\n" +
            "** ''The King of Prussia Courier'' {{WS|kingofprussiacourier.com}} of [[King of Prussia, Pennsylvania]]\n" +
            "\n" +
            "* Delaware County News Network {{WS|delconewsnetwork.com}} \n" +
            "** ''News of Delaware County'' {{WS|newsofdelawarecounty.com}} of [[Havertown, Pennsylvania]]\n" +
            "** ''County Press'' {{WS|countypressonline.com}} of [[Newtown Square, Pennsylvania]]\n" +
            "** ''Garnet Valley Press'' {{WS|countypressonline.com}} of [[Glen Mills, Pennsylvania]]\n" +
            "** ''Springfield Press'' {{WS|countypressonline.com}} of [[Springfield, Pennsylvania]]\n" +
            "** ''Town Talk'' {{WS|towntalknews.com}} of [[Ridley, Pennsylvania]]\n" +
            "\n" +
            "* Berks-Mont Newspapers {{WS|berksmontnews.com}} \n" +
            "** ''The Boyertown Area Times'' {{WS|berksmontnews.com/boyertown_area_times}} of [[Boyertown, Pennsylvania]]\n" +
            "** ''The Kutztown Area Patriot'' {{WS|berksmontnews.com/kutztown_area_patriot}} of [[Kutztown, Pennsylvania]]\n" +
            "** ''The Hamburg Area Item'' {{WS|berksmontnews.com/hamburg_area_item}} of [[Hamburg, Pennsylvania]]\n" +
            "** ''The Southern Berks News'' {{WS|berksmontnews.com/southern_berks_news}} of [[Exeter Township, Berks County, Pennsylvania]]\n" +
            "** ''Community Connection'' {{WS|berksmontnews.com/community_connection}} of [[Boyertown, Pennsylvania]]\n" +
            "\n" +
            "* Magazines\n" +
            "** ''Bucks Co. Town & Country Living'' {{WS|buckscountymagazine.com}} \n" +
            "** ''Parents Express'' {{WS|parents-express.com}} \n" +
            "** ''Real Men, Rednecks'' {{WS|realmenredneck.com}} \n" +
            "\n" +
            "{{JRC}}\n" +
            "\n" +
            "==References==\n" +
            "<references />\n" +
            "\n" +
            "[[Category:Journal Register publications|*]]";

  public static void main(String args[]) {
    //String text1 = readFile("name/fraser/neil/plaintext/Speedtest1.txt");
    //String text2 = readFile("name/fraser/neil/plaintext/Speedtest2.txt");

    diff_match_patch dmp = new diff_match_patch();
    dmp.Diff_Timeout = 0;

    // Execute one reverse diff as a warmup.
    dmp.diff_main(text2, text1, false);
    System.gc();

    long start_time = System.currentTimeMillis();
    dmp.diff_main(text1, text2, false);
    long end_time = System.currentTimeMillis();
    System.out.printf("Elapsed time: %f\n", ((end_time - start_time) / 1000.0));
  }

  private static String readFile(String filename) {
    // Read a file from disk and return the text contents.
    StringBuffer strbuf = new StringBuffer();
    try {
      FileReader input = new FileReader(filename);
      BufferedReader bufRead = new BufferedReader(input);
      String line = bufRead.readLine();
      while (line != null) {
        strbuf.append(line);
        strbuf.append('\n');
        line = bufRead.readLine();
      }
      
      bufRead.close();
     
    } catch (IOException e) {
      e.printStackTrace();
    }
    return strbuf.toString();
  }
}
