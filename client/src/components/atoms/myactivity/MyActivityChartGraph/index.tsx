import React from 'react';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';
import { IMyKeyword } from 'types/keyword';
// import { DUMMY_MYKEYWORDS } from 'constants/dummyreadarticle';
import { MyActivityChartGraphWrapper } from './style';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

interface IMyActivityChartGraphProps {
	myTopKeyword: IMyKeyword[];
}
function MyActivityChartGraph(props: IMyActivityChartGraphProps) {
	const { myTopKeyword } = props;
	console.log(myTopKeyword);
	// const mykeyword = DUMMY_MYKEYWORDS;
	const chartBarColors = [
		'rgb(249, 65, 68)',
		'rgb(243, 144, 44)',
		'rgb(248, 150, 30)',
		'rgb(249, 199, 79)',
		'rgb(144, 190, 119)',
	];
	const options = {
		responsive: true,
		maintainAspectRatio: false,
		plugins: {
			legend: {
				position: 'bottom' as const,
				labels: {
					generateLabels: (chart: ChartJS) => {
						const { data } = chart;
						const labels = data.labels || [];
						return labels.map((label, index) => ({
							text: label as string,
							fillStyle: chartBarColors[index],
							strokeStyle: 'white',
						}));
					},
					font: {
						size: 14,
						color: 'black',
						weight: 'bold',
					},
				},
			},
			title: {
				display: true,
				text: '키워드 통계',
				font: {
					size: 20,
				},
			},
		},
		scales: {
			x: {
				display: true,
				labels: ['', '', '', '', ''],
			},
			y: {
				display: true,
				ticks: {
					maxTicksLimit: 5,
					font: {
						size: 14,
					},
					color: 'black',
				},
			},
		},
		layout: {
			padding: {
				left: 10, // 좌측 여백 조절
				right: 20, // 우측 여백 조절
				top: 20, // 상단 여백 조절
			},
		},
	};
	const labels = myTopKeyword.map((keyword) => keyword.keyword);
	const keywordCnt = myTopKeyword.map((keyword) => keyword.count);

	const data = {
		labels,
		datasets: [
			{
				// data: [12, 19, 3, 5, 2],
				data: keywordCnt,
				backgroundColor: chartBarColors,
			},
		],
	};
	return (
		<MyActivityChartGraphWrapper>
			<div className="chart-graph">
				<Bar options={options} data={data} style={{ position: 'relative', height: '300px' }} />
			</div>
		</MyActivityChartGraphWrapper>
	);
}

export default MyActivityChartGraph;
